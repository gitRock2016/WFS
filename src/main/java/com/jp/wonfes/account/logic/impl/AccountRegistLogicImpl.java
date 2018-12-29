package com.jp.wonfes.account.logic.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.jp.wonfes.account.logic.AccountRegistLogic;
import com.jp.wonfes.account.logic.dto.RegistAccountDto;
import com.jp.wonfes.cmmn.dao.mapper.UsrMapper;
import com.jp.wonfes.cmmn.dao.qo.Usr;
import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsMessage;
import com.jp.wonfes.common.WfsSysytemException;
import com.jp.wonfes.service.dao.WfsDataException;

@Service
public class AccountRegistLogicImpl implements AccountRegistLogic{

	@Autowired
	private UsrMapper usrmapper;
	@Autowired
	private WfsMessage msg;
	
	@Override
	public void registAccountInfo(RegistAccountDto dto) throws WfsLogicException {
		
		String userid = dto.getUserid();
		String username = dto.getUsername();
		String password = dto.getPassword();
		
		// 登録対象が既に存在しているかどうか
		if (usrmapper.selectByPrimaryKey(userid) != null) {
			throw new WfsLogicException(msg.getMessage("wfs.msg.e.cmmn3", new String[] { "登録対象のアカウント情報" }));
		}

		Usr usr = new Usr();
		usr.setUsrId(userid);
		usr.setPasswd(DigestUtils.md5DigestAsHex(password.getBytes()));
		usr.setUserName(username);
		Date date = this.getNow();
		usr.setInsDate(date);
		usr.setUpdDate(date);
		usrmapper.insert(usr);
		
	}
	
	private Date getNow() {
		LocalDateTime localDateTime = LocalDateTime.now();
		ZoneId zone = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zone);
		Instant instant = zonedDateTime.toInstant();
		return Date.from(instant);
	}

}
