package com.jp.wonfes.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WfsImgLogicImpl implements WfsImgLogic {
	
	private final String osName=System.getProperty("os.name").toLowerCase();

	@Autowired
	ImgIconUrl ImgIconUrl;
	
	@Override
	public void save(WfsImgIcon imgIcon) throws IOException {
		// dealerId毎のフォルダ作成
		final String iconFolderByDealerId = this.ImgIconUrl.getImgFilePath() + File.separator + imgIcon.getDealerId();
		Path savePlaceByDealerIdPath = Paths.get(iconFolderByDealerId);
		if (!Files.isDirectory(savePlaceByDealerIdPath)) {
			Files.createDirectory(savePlaceByDealerIdPath);
		}

		// 画像アイコンの保存
		final String iconAbsoluteFileName = iconFolderByDealerId + File.separator + imgIcon.getWfsImgIconName();
		File imgIconAbsoluteFile = new File(iconAbsoluteFileName);
		imgIcon.transferTo(imgIconAbsoluteFile);
		if(! osName.startsWith("windows")) {
			Files.setPosixFilePermissions(savePlaceByDealerIdPath, PosixFilePermissions.fromString("rw-rw-rw-"));
			// 以下うまく行かかないのでコメントアウト、原因不明
//			imgIconAbsoluteFile.setWritable(true, false); // 権限付与 rw-rw-rw-
			Files.setPosixFilePermissions(Paths.get(iconAbsoluteFileName), PosixFilePermissions.fromString("rw-rw-rw-"));
			
		}
		
	}

}
