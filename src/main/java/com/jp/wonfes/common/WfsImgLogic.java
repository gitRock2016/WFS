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
	 * 商品画像を保存する
	 * TODO いづれ作りたい
	 * @param imgIcon
	 */
//	void save(WfsImgProduct imgProduct);

}
