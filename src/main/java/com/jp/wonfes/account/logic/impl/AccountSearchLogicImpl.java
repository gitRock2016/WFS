package com.jp.wonfes.account.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.wonfes.account.dao.mapper.UserSearchMapper;
import com.jp.wonfes.account.dao.qo.SelectUserFavProductsQoResp;
import com.jp.wonfes.account.logic.AccountSearchLogic;
import com.jp.wonfes.account.logic.dto.SearchAccountDtoReq;
import com.jp.wonfes.account.logic.dto.SearchAccountDtoResp;
import com.jp.wonfes.account.logic.dto.SearchUsersInfoDtoResp;
import com.jp.wonfes.cmmn.dao.mapper.UsrDetailFavProductsMapper;
import com.jp.wonfes.common.WfsLogicException;

@Service
public class AccountSearchLogicImpl implements AccountSearchLogic{

	@Autowired
	private UserSearchMapper userSearchMapper;
	@Autowired
	private UsrDetailFavProductsMapper usrDetailFavProductsMapper;

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
	public List<SearchUsersInfoDtoResp> searchUsersInfo() throws WfsLogicException {
		// TODO
		// Daoの作成、ユーザー系テーブルを３つ結合する

		// Daoからユーザー情報をまとめて取得
		
		// 画面表示用に整形
		
		return null;
	}



}
