package com.jp.wonfes.account.logic;

import com.jp.wonfes.account.logic.dto.CheckAccountDto;
import com.jp.wonfes.common.WfsLogicException;

public interface AccountManageLogic {
	void checkAccountInfo(CheckAccountDto dto) throws WfsLogicException;
	void deleteAccountInfo(String userId) throws WfsLogicException;
}
