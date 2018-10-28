package com.jp.wonfes.dealer.logic;

import java.util.List;

import com.jp.wonfes.dealer.logic.dto.SearchDealerInfoDtoReq;
import com.jp.wonfes.dealer.logic.dto.SearchDealerInfoDtoResp;

public interface DealerSearchLogic {
	List<SearchDealerInfoDtoResp> searchDealerInfoList(SearchDealerInfoDtoReq dto);
}
