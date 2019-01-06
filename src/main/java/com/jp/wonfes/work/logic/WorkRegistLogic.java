package com.jp.wonfes.work.logic;

import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsSysytemException;
import com.jp.wonfes.work.logic.dto.WorkEditInfoDtoReq;
import com.jp.wonfes.work.logic.dto.WorkRegistInfoDtoReq;
import com.jp.wonfes.work.logic.dto.WorkRegistInfoDtoResp;

public interface WorkRegistLogic {
	/**
	 * 作品情報の新規登録処理
	 * <p>返却値は以下のようにすること
	 * <ul>
	 * <li>dealerId, 引数のDTOと同じ値
	 * <li>productId, 新規採番したId
	 * </ul>
	 * @param req
	 * @return
	 * @throws WfsLogicException
	 * @throws WfsSysytemException
	 */
	WorkRegistInfoDtoResp registWorkInfo(WorkRegistInfoDtoReq req) throws WfsLogicException, WfsSysytemException;
	
	/**
	 * 作品情報の編集処理
	 * @param req
	 * @throws WfsLogicException
	 * @throws WfsSysytemException
	 */
	void editWorkInfo(WorkEditInfoDtoReq req) throws WfsLogicException, WfsSysytemException;
}
