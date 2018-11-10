package com.jp.wonfes.common;

public abstract class WfsAbstractFile {
	/** 画像ファイルとして認証された拡張子*/
	/** TODO アイコン画像、商品画像などで相違がある場合は、実装クラスで定義する*/
	protected static final String[] extentionList = { "jpeg", "jpg", "png", "bmp" };
	protected static final String period = ".";

	protected String[] getAuthorizedExtentionList() {
		return extentionList;
	}
	
	protected String getAuthorizedExtentionListJoined() {
		StringBuilder sb = new StringBuilder();
		for(String ext : extentionList) {
			if(sb.length()>0) {
				sb.append(',');
			}
			sb.append(ext);
		}
		return sb.toString();
	}
	
}
