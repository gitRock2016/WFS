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
import com.jp.wonfes.common.WfsLogicException;

@Service
public class AccountSearchLogicImpl implements AccountSearchLogic{

	@Autowired
	private UserSearchMapper userSearchMapper;

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



}
