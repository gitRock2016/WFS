package com.jp.wonfes.dealer.logic;

import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsSysytemException;
import com.jp.wonfes.dealer.logic.dto.DeleteDealerInfoDto;
import com.jp.wonfes.dealer.logic.dto.EditDealerInfoDto;
import com.jp.wonfes.dealer.logic.dto.RegistDealerInfoDto;
import com.jp.wonfes.dealer.logic.dto.RegistDealerInfoDtoResp;

public interface DealerRegistLogic {
	RegistDealerInfoDtoResp registDealerInfo(RegistDealerInfoDto dto) throws WfsLogicException, WfsSysytemException;
	void editDealerInfo(EditDealerInfoDto dto) throws WfsLogicException, WfsSysytemException ;
	void deleteDealerInfo(DeleteDealerInfoDto dto) throws WfsLogicException;
}
