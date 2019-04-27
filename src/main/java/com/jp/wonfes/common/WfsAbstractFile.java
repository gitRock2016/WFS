package com.jp.wonfes.common;

import com.google.common.base.Strings;

public abstract class WfsAbstractFile {
	/** 画像ファイルとして認証された拡張子*/
	protected static final String[] extentionList = { "jpeg", "jpg", "png", "bmp" };
	protected static final String period = ".";

	public String[] getAuthorizedExtentionList() {
		return extentionList;
	}
	
	public String getAuthorizedExtentionListJoined() {
		StringBuilder sb = new StringBuilder();
		for(String ext : extentionList) {
			if(sb.length()>0) {
				sb.append(',');
			}
			sb.append(ext);
		}
		return sb.toString();
	}
	
	/**
	 * ファイル名の拡張子を返却する
	 * 拡張子が取得できない場合、空文字を返却する
	 * @param val
	 * @return 拡張子
	 */
	protected String getExtention(String val) {
		if (!Strings.isNullOrEmpty(val)) {
			String _name = val;
			int index = _name.lastIndexOf(".");
			if (index == -1) {
				return "";
				// throw new IllegalStateException("アイコン画像に拡張子がありません");
			}
			return _name.substring(index + 1, _name.length());
		}
		return "";
	}
	
	
}
