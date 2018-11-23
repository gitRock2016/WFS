package com.jp.wonfes.domain.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.google.common.base.CharMatcher;
import com.google.common.base.Objects;
import com.jp.wonfes.cmmn.dao.mapper.UsrMapper;
import com.jp.wonfes.cmmn.dao.qo.Usr;
import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsMessage;

@Service
public class AuthManageLogicImpl implements AuthManageLogic {

	@Autowired
	private UsrMapper usrmapper;
	@Autowired
	private WfsMessage msg;

	@Override
	public boolean isAuth(String userid, String password) throws WfsLogicException {
		Usr u = usrmapper.selectByPrimaryKey(userid);
		if (u == null) {
			throw new WfsLogicException(msg.getMessage("wfs.msg.e.accnt3"));
		}
		String dbpwd = CharMatcher.WHITESPACE.trimTrailingFrom(u.getPasswd());
		String rqpwd = DigestUtils.md5DigestAsHex(password.getBytes());
		if (!Objects.equal(dbpwd, rqpwd)) {
			throw new WfsLogicException(msg.getMessage("wfs.msg.e.accnt2"));
		}
		return true;
	}

}
