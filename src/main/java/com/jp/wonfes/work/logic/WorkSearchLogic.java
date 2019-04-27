package com.jp.wonfes.work.logic;

import java.util.List;

import com.jp.wonfes.work.logic.dto.SearcWorkCondDtoReq;
import com.jp.wonfes.work.logic.dto.SearchWorkInfoRow;
import com.jp.wonfes.work.logic.dto.WorkInfoDtoReq;
import com.jp.wonfes.work.logic.dto.WorkInfoDtoResp;

public interface WorkSearchLogic {
	WorkInfoDtoResp searchWorkInfo(WorkInfoDtoReq dto);
	List<SearchWorkInfoRow> searchWorkInfoList(SearcWorkCondDtoReq dto);
}
