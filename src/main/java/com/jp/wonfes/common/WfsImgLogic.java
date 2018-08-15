package com.jp.wonfes.common;

import java.io.IOException;

public interface WfsImgLogic {
	/**
	 * アイコン画像を保存する
	 * @param imgIcon
	 * @throws IOException 
	 */
	void save(WfsImgIcon imgIcon) throws IOException;
	
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

}
