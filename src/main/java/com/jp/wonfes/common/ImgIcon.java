package com.jp.wonfes.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public class ImgIcon {
	
//	@Autowired
//	private WfsApplicationConf wfsApplicationConf; 
	
	private static final int iconFileNameMaxLength = 10;
	private static final String[] extentionList = {"jpeg","jpg","gif","png","BMP"};

	private String dealerId;
	private MultipartFile imgIcon;
	private String imgIconName;
	private String savePlaceByDealerId;
	private String ImgIconAbsoluteFileName;

	public ImgIcon(String dealerId, MultipartFile dealerIconImg, String wfsImgPath) {
		this.dealerId = dealerId;
		this.imgIcon = dealerIconImg;
		this.imgIconName = this.getFormatIconName(dealerIconImg.getOriginalFilename());
		// TODO window専用の対応
		this.savePlaceByDealerId = wfsImgPath + "\\" + dealerId;
//		this.savePlaceByDealerId = wfsApplicationConf.getWfsImgPath() + "\\" + dealerId;
		this.ImgIconAbsoluteFileName = this.savePlaceByDealerId + "\\" + this.imgIconName;
	}
	
	// ファイル名の取得
	public String getImgIconName() {
		return imgIconName;
	}

	// 画像アイコンの保存
	public void saveIcon() throws IOException {

		// dealerId毎のフォルダ作成
		Path savePlaceByDealerIdPath = Paths.get(this.savePlaceByDealerId);
		if (!Files.isDirectory(savePlaceByDealerIdPath)) {
			Files.createDirectory(savePlaceByDealerIdPath);
		}

		// 画像アイコンの保存
		File imgIconAbsoluteFile = new File(this.ImgIconAbsoluteFileName);
		this.imgIcon.transferTo(imgIconAbsoluteFile);

	}
	
	// 拡張子の取得
	public String getExtention() {
		return this.getExtention(this.imgIconName);
	}

	// 画像ファイルであるかどうか
	public boolean isImgFile() {
		// TODO extentionListに拡張子が含まれるかどうかを判定すること
		// 暫定TRUE
		List<String> l = Arrays.asList(extentionList);
		return l.contains(this.getExtention());
	}
	
	// ---------------------------------------------------------------------------------------
	// private
	// ---------------------------------------------------------------------------------------
	private String getExtention(String fileName) {
		int index = fileName.lastIndexOf(".");
		if(index == -1) {
			// 拡張子なし
			return "";
		}
		return fileName.substring(index, fileName.length());
	}
	
	/**
	 * 以下のように整形する
	 * 例１：1234567890.jpg, 14桁→123456.jpg, 10桁
	 * 例２：12345.JPEG, 10桁→12345.JPEG, 10桁
	 * 例３：1234567890.KOJ→123.JPEG
	 * 拡張子の桁数（例なら４桁）を除き最大桁数（１０桁）に収まるよう名前を整形する
	 * 
	 * @param name
	 * @return
	 */
//	private String getFormatIconName(String iconName) {
//		
//		boolean isExtention = iconName.lastIndexOf(".") != -1 ? true : false;
//		
//		int _fileNameMax = iconFileNameMaxLength;
//		String extention="";
//		if(isExtention) {
//			int startExtention = iconName.lastIndexOf(".");
//			extention = iconName.substring(startExtention, iconName.length());
//			_fileNameMax = iconFileNameMaxLength - extention.length();
//		}
//		
//		String _fileName = iconName.substring(0, _fileNameMax);
//		return _fileName + extention;
//	}
	
	/**
	 * @param name
	 * @return
	 */
	private String getFormatIconName(String dealerOriginalName) {
		String extention = getExtention(dealerOriginalName);
		String iconName = "i_" + dealerId + extention;
		if(iconName.length()>10) {
			throw new IllegalStateException("登録するアイコン名が10桁をこえています");
		}
		return iconName;
	}
	
	
}
