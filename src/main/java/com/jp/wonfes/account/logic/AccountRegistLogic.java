package com.jp.wonfes.account.logic;

import com.jp.wonfes.account.logic.dto.RegistAccountDto;
import com.jp.wonfes.common.WfsLogicException;

public interface AccountRegistLogic {
	void registAccountInfo(RegistAccountDto dto) throws WfsLogicException;

}
