package com.jp.wonfes.dealer.logic;

import java.io.IOException;

import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsSysytemException;
import com.jp.wonfes.dealer.logic.dto.DelteDealerInfo;
import com.jp.wonfes.dealer.logic.dto.EditDealerInfo;
import com.jp.wonfes.dealer.logic.dto.RegistDealerInfo;

public interface DealerRegistLogic {
	void registDealerInfo(RegistDealerInfo dto) throws WfsLogicException, WfsSysytemException;
	void editDealerInfo(EditDealerInfo dto);
	void delteDealerInfo(DelteDealerInfo dto);
}
