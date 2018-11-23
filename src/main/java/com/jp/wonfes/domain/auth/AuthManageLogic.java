package com.jp.wonfes.domain.auth;

import com.jp.wonfes.common.WfsLogicException;

public interface AuthManageLogic {
	boolean isAuth(String userid, String password) throws WfsLogicException;
}
