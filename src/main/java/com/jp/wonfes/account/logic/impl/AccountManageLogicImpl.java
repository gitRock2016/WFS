package com.jp.wonfes.account.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.CharMatcher;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.jp.wonfes.account.logic.AccountManageLogic;
import com.jp.wonfes.account.logic.dto.CheckAccountDto;
import com.jp.wonfes.cmmn.dao.mapper.UsrMapper;
import com.jp.wonfes.cmmn.dao.qo.Usr;
import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsMessage;
import com.jp.wonfes.domain.auth.AuthManage;

@Service
public class AccountManageLogicImpl implements AccountManageLogic {

	@Autowired
	private UsrMapper usrmapper;
	@Autowired
	private WfsMessage msg;
	
	@Override
	public void checkAccountInfo(CheckAccountDto dto) throws WfsLogicException {

		String userid = dto.getUserid();
		String password = dto.getPassword();

		Usr u = usrmapper.selectByPrimaryKey(userid);
		if (u == null) {
			throw new WfsLogicException(msg.getMessage("wfs.msg.e.accnt3"));
		}
		// DBから取得したパスワード
		String dbpwd = CharMatcher.WHITESPACE.trimTrailingFrom(u.getPasswd());
		// 画面から取得したパスワード
		String rqpwd = AuthManage.getPasswordEnryptionAccount(password);
		if (!Objects.equal(dbpwd, rqpwd)) {
			throw new WfsLogicException(msg.getMessage("wfs.msg.e.accnt2"));
		}
	}

	@Override
	public void deleteAccountInfo(String userId) throws WfsLogicException {
		if(Strings.isNullOrEmpty(userId)) {
			throw new WfsLogicException(msg.getMessage("wfs.msg.e.cmmn4"));
		}
		
		int count = usrmapper.deleteByPrimaryKey(userId);
		if (count == 0) {
			throw new WfsLogicException(msg.getMessage("wfs.msg.e.cmmn5"));
		}
	}

}
