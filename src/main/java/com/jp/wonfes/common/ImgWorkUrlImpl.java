package com.jp.wonfes.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO ImgIconと同じ実装、アイコン画像と共有できない場合、実装を変更すること
 * @author rock
 *
 */
@Service
public class ImgWorkUrlImpl implements ImgWorkUrl {
	
	@Autowired
	private ImgIconUrlImpl imgIconUrlImpl;
	
	@Override
	public String getImgFilePath() {
		return imgIconUrlImpl.getImgFilePath();
	}

	@Override
	public String getImgWorkFilePath(Integer userId, String fileName) {
		return imgIconUrlImpl.getImgIconFilePath(userId, fileName);
	}

	@Override
	public String getDefaultWorkFilePath() {
		return imgIconUrlImpl.getDefaultImgIconFilePath();
	}

}
