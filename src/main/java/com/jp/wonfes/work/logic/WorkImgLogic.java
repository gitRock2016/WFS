package com.jp.wonfes.work.logic;

import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsSysytemException;
import com.jp.wonfes.domain.work.WorkImg;

public interface WorkImgLogic {
	/**
	 * 画像ファイル自体の登録処理<br>
	 * 同名ファイルが存在する場合、上書きして保存する<br>
	 * ファイルが空の場合、登録処理を行わない
	 * @param workImg
	 * @throws WfsLogicException
	 * @throws WfsSysytemException
	 */
	void registWorkImg(WorkImg workImg) throws WfsLogicException, WfsSysytemException;
	
	/**
	 * 画像ファイルの登録前に行うチェック
	 * <ul>
	 * <li>画像ファイルのサイズが許容サイズかどうか
	 * <li>画像ファイルの拡張子が許容されたものかどうか
	 * </ul>
	 * @param workImg
	 * @throws WfsLogicException
	 * @throws WfsSysytemException
	 */
	void checkWorkImg(WorkImg workImg) throws WfsLogicException, WfsSysytemException;
}
