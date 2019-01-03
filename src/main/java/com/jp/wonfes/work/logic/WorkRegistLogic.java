package com.jp.wonfes.work.logic;

import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsSysytemException;
import com.jp.wonfes.domain.work.WorkImg;
import com.jp.wonfes.work.logic.dto.WorkRegistInfoDtoReq;

public interface WorkRegistLogic {
	void registWorkInfo(WorkRegistInfoDtoReq req) throws WfsLogicException, WfsSysytemException;
}
