package com.jp.wonfes.work.logic;

import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsSysytemException;
import com.jp.wonfes.work.logic.dto.WorkEditInfoDtoReq;
import com.jp.wonfes.work.logic.dto.WorkRegistInfoDtoReq;
import com.jp.wonfes.work.logic.dto.WorkRegistInfoDtoResp;

public interface WorkRegistLogic {
	WorkRegistInfoDtoResp registWorkInfo(WorkRegistInfoDtoReq req) throws WfsLogicException, WfsSysytemException;
	void editWorkInfo(WorkEditInfoDtoReq req) throws WfsLogicException, WfsSysytemException;
}
