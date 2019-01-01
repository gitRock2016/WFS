package com.jp.wonfes.work.logic;

import com.jp.wonfes.work.logic.dto.WorkInfoDtoReq;
import com.jp.wonfes.work.logic.dto.WorkInfoDtoResp;

public interface WorkSearchLogic {
	WorkInfoDtoResp searchWorkInfo(WorkInfoDtoReq dto);
}
