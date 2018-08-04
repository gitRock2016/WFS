package com.jp.wonfes.common;

public interface ImgIconUrl {
	String getImgFilePath();
	String getImgIconFilePath(Integer userId, String fileName);
	String getDefaultImgIconFilePath();
}
