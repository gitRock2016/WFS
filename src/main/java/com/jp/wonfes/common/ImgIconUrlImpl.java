package com.jp.wonfes.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImgIconUrlImpl implements ImgIconUrl {

	@Autowired
	private WfsApplicationConf wfsApplicationConf; 
	
	@Override
	public String getImgIconFilePath(Integer userId, String fileName) {
		return wfsApplicationConf.getWfsImgUrl() + String.valueOf(userId) + "/" + fileName;
	}

	@Override
	public String getDefaultImgIconFilePath() {
		return wfsApplicationConf.getWfsImgUrl() + wfsApplicationConf.getWfsImgDefaultFolder() +"/" +wfsApplicationConf.getWfsImgDefaultFile();
	}

}
