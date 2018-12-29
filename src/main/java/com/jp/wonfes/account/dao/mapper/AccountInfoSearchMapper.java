package com.jp.wonfes.account.dao.mapper;

import java.util.List;

import com.jp.wonfes.account.dao.mapper.qo.SelectAccountUserInfoQoReq;
import com.jp.wonfes.account.dao.qo.SelectAccountUserInfoQoResp;

public interface AccountInfoSearchMapper {
	List<SelectAccountUserInfoQoResp> selectAccountUserInfoDetails(SelectAccountUserInfoQoReq qoReq);

}
