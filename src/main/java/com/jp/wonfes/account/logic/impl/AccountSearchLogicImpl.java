package com.jp.wonfes.account.logic.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.wonfes.account.dao.mapper.UserSearchMapper;
import com.jp.wonfes.account.dao.qo.SelectAccountUserInfoQoResp;
import com.jp.wonfes.account.dao.qo.SelectUserFavProductsQoResp;
import com.jp.wonfes.account.logic.AccountSearchLogic;
import com.jp.wonfes.account.logic.dto.SearchAccountDtoReq;
import com.jp.wonfes.account.logic.dto.SearchAccountDtoResp;
import com.jp.wonfes.account.logic.dto.SearchUsersInfoDtoResp;
import com.jp.wonfes.cmmn.dao.mapper.UsrDetailFavProductsMapper;
import com.jp.wonfes.cmmn.dao.mapper.UsrMapper;
import com.jp.wonfes.cmmn.dao.qo.Usr;
import com.jp.wonfes.cmmn.dao.qo.UsrExample;
import com.jp.wonfes.common.WfsLogicException;

@Service
public class AccountSearchLogicImpl implements AccountSearchLogic{

	@Autowired
	private UserSearchMapper userSearchMapper;
	@Autowired
	private UsrMapper usrMapper;
	
	@Override
	public List<SearchAccountDtoResp> searchAccountInfo(SearchAccountDtoReq dto) throws WfsLogicException {
		String userId = dto.getUsrId();
		
		List<SelectUserFavProductsQoResp> qolist=userSearchMapper.selectUserFavProducts(userId);
		
		List<SearchAccountDtoResp> list = new ArrayList<>();
		for(SelectUserFavProductsQoResp q : qolist) {
			SearchAccountDtoResp resp = SearchAccountDtoResp.qo2Dto(q);
			list.add(resp);
		}
		
		return list;
	}

	@Override
	public List<SearchUsersInfoDtoResp> searchUsersInfo() {
		// TODO
		// Daoの作成、ユーザー系テーブルを３つ結合する

		// Daoからユーザー情報をまとめて取得
		List<SelectAccountUserInfoQoResp> list = userSearchMapper.selectAccountUserInfoDetails(null);

		// 画面表示用に整形
		List<SearchUsersInfoDtoResp> alist = new ArrayList<SearchUsersInfoDtoResp>();
		String befUsrId = null;
		for (SelectAccountUserInfoQoResp q : list) {
			String usrId = q.getUsrId();
			if (!usrId.equals(befUsrId)) {
				// 値を詰め替える
				SearchUsersInfoDtoResp resp = qo2dto(q);
				// Listに設定
				alist.add(resp);
				befUsrId = usrId;
			}
		}
		return alist;
	}

	private SearchUsersInfoDtoResp qo2dto(SelectAccountUserInfoQoResp qo) {
		SearchUsersInfoDtoResp dto = new SearchUsersInfoDtoResp();
		dto.setUsrId(qo.getDealerId());
		
		// TODO ENUMにする
		String isExistFavProduct = qo.getDealerId() != null ? "1" : "0";
		dto.setIsExistFavProduct(isExistFavProduct);
		
		String insDate;
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime _insDate = qo.getInsDate();
		insDate = _insDate.format(f);
		dto.setInsDate(insDate);
		return dto;
	}



}
