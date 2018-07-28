package com.jp.wonfes.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WfsApplicationConf {
	
	@Value("${wfs.img.path}")
	private String wfsImgPath;

	public String getWfsImgPath() {
		return wfsImgPath;
	}
	
}
