package com.jp.wonfes.common;

public interface ImgWorkUrl {
	String getImgFilePath();
	String getImgWorkFilePath(Integer userId, String fileName);
	String getDefaultWorkFilePath();
}
