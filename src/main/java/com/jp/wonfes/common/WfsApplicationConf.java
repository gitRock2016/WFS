package com.jp.wonfes.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WfsApplicationConf {
	@Value("${wfs.url}")
	private String wfsUrl;
	@Value("${wfs.img.url}")
	private String wfsImgUrl;
	@Value("${wfs.img.path}")
	private String wfsImgPath;
	@Value("${wfs.img.default.folder}")
	private String wfsImgDefaultFolder;
	@Value("${wfs.img.default.file}")
	private String wfsImgDefaultFile;
	
	public String getWfsUrl() {
		return wfsUrl;
	}
	public String getWfsImgUrl() {
		return wfsImgUrl;
	}
	public String getWfsImgPath() {
		return wfsImgPath;
	}
	public String getWfsImgDefaultFolder() {
		return wfsImgDefaultFolder;
	}
	public String getWfsImgDefaultFile() {
		return wfsImgDefaultFile;
	}

}
