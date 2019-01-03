package com.jp.wonfes.work.logic;

import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsSysytemException;
import com.jp.wonfes.domain.work.WorkImg;

public interface WorkImgLogic {
	void registWorkImg(WorkImg workImg) throws WfsLogicException, WfsSysytemException;
	void checkWorkImg(WorkImg workImg) throws WfsLogicException, WfsSysytemException;
}
