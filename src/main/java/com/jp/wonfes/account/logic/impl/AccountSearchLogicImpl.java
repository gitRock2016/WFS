package com.jp.wonfes.account.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.wonfes.account.dao.mapper.AccountInfoSearchMapper;
import com.jp.wonfes.account.dao.mapper.UserSearchMapper;
import com.jp.wonfes.account.dao.mapper.qo.SelectAccountUserInfoQoReq;
import com.jp.wonfes.account.dao.qo.SelectAccountUserInfoQoResp;
import com.jp.wonfes.account.dao.qo.SelectUserFavProductsQoResp;
import com.jp.wonfes.account.logic.AccountSearchLogic;
import com.jp.wonfes.account.logic.dto.SearchAccountDtoReq;
import com.jp.wonfes.account.logic.dto.SearchAccountDtoResp;
import com.jp.wonfes.account.logic.dto.SearchUsersInfoDtoReq;
import com.jp.wonfes.account.logic.dto.SearchUsersInfoDtoResp;
import com.jp.wonfes.common.WfsLogicException;

@Service
public class AccountSearchLogicImpl implements AccountSearchLogic{

	@Autowired
	private UserSearchMapper userSearchMapper;
	@Autowired
	private AccountInfoSearchMapper accountInfoSearchMapper;
	
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
	public List<SearchUsersInfoDtoResp> searchUsersInfo(SearchUsersInfoDtoReq dto) {
		
		SelectAccountUserInfoQoReq qoReq = new SelectAccountUserInfoQoReq();
		qoReq.setUserId(dto.getUserId());
		List<SelectAccountUserInfoQoResp> list = accountInfoSearchMapper.selectAccountUserInfoDetails(qoReq);

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
		dto.setUsrId(qo.getUsrId());
		
		String isExistFavProduct = qo.getDealerId() != null ? "あり" : "なし";
		dto.setIsExistFavProduct(isExistFavProduct);

		dto.setInsDate(qo.getInsDate());
		return dto;
	}



}
