package com.jp.wonfes.common;

import java.io.IOException;


public interface WfsImgLogic {
	/**
	 * アイコン画像を保存する
	 * @param imgIcon
	 * @throws IOException 
	 * @throws WfsSysytemException 
	 */
	void save(WfsImgIcon imgIcon) throws WfsLogicException, WfsSysytemException;
	
	/**
	 * アイコン画像を削除する
	 * @param imgIcon
	 * @throws IOException 
	 * @throws WfsLogicException 
	 */
	void del(WfsImgIcon imgIcon) throws IOException, WfsLogicException;
	
	/**
	 * 商品画像を保存する
	 * TODO いづれ作りたい
	 * @param imgIcon
	 */
//	void save(WfsImgProduct imgProduct);
	
	/**
	 * アイコン画像ファイルに対するチェックを行う
	 * @param imgIcon
	 * @throws IOException
	 */
	void checkFile(WfsImgIcon imgIcon) throws WfsLogicException;

	
}
