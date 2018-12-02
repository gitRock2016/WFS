package com.jp.wonfes.account.logic;

import java.util.List;

import com.jp.wonfes.account.logic.dto.SearchAccountDtoReq;
import com.jp.wonfes.account.logic.dto.SearchAccountDtoResp;
import com.jp.wonfes.common.WfsLogicException;

public interface AccountSearchLogic {
	List<SearchAccountDtoResp> searchAccountInfo(SearchAccountDtoReq dto) throws WfsLogicException;

}
