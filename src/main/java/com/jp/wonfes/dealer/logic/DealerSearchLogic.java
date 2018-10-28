package com.jp.wonfes.dealer.logic;

import java.util.List;

import com.jp.wonfes.dealer.logic.dto.SearchDealerInfoDtoReq;
import com.jp.wonfes.dealer.logic.dto.SearchDealerInfoDtoResp;
import com.jp.wonfes.service.dao.WfsDataException;

public interface DealerSearchLogic {
	SearchDealerInfoDtoResp searchDealerInfo(SearchDealerInfoDtoReq dto) throws WfsDataException;
	List<SearchDealerInfoDtoResp> searchDealerInfoList(SearchDealerInfoDtoReq dto);
}
