package com.jp.wonfes.common;

import org.springframework.web.multipart.MultipartFile;

public class ImgIconUrlBK {

	private static final String basicImgUrl = "http://localhost:8080/WonFesSys/img/";
	private static final String defaultFileFolder = "default";
	private static final String defaultFileName = "default_1.jpg";

	private String userId;
	private String imgIconFileName;

	public ImgIconUrlBK(String userId, String imgIconFileName) {
		this.userId = userId;
		this.imgIconFileName = imgIconFileName;
	}

	public ImgIconUrlBK(Integer userId, String imgIconFileName) {
		this.userId = Integer.toString(userId);
		this.imgIconFileName = imgIconFileName;
	}

	public ImgIconUrlBK(MultipartFile file) {
		// TODO ImgIconはMultipartFileをインスタンス変数にもつ。似た感じであつかえるようにしたい
	}

	public String getImgIconUrl() {
		return basicImgUrl + this.userId + "/" + this.imgIconFileName;
	}
	
	public String getImgIconDefaultUrl() {
		return basicImgUrl + defaultFileFolder + "/" + defaultFileName;
	}

}
