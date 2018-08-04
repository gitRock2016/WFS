package com.jp.wonfes.common;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class WfsImgIcon extends WfsAbstractFile {
	private static final String img_icon_prefix = "i_";
	private static final String[] extentionList = { "jpeg", "jpg", "png", "bmp" };

	private final MultipartFile imgIcon;
	private final Integer dealerId;
	private final String extention;

	public WfsImgIcon(MultipartFile imgIcon, Integer dealerId) {
		super();
		this.imgIcon = imgIcon;
		this.dealerId = dealerId;
		this.extention = this.getWfsExtention();
		
		// TODO 画像アイコンであることのチェックを行う、DI使う？
		// 拡張子がなければエラー
		// 拡張子が画像アイコンでなければエラー
		// アイコンファイル名が拡張子を含め10桁を超える場合（テーブル定義を拡張したほうがいい）
		
	}
	
	/**
	 * TODO
	 * ファイルが存在していればTRUEを返却する
	 * ファイルのバイト数が0バイト
	 * @return
	 */
	public boolean exists() {
		return this.getSize() != 0 ? true :false ;
	}
	
	public String getWfsImgIconName() {
		return img_icon_prefix + this.dealerId + this.extention;
	}
	
	private String getWfsExtention() {
		String _name = this.imgIcon.getOriginalFilename();
		int index = _name.lastIndexOf(".");
		if(index == -1) {
			throw new IllegalStateException("アイコン画像に拡張子がありません");
		}
		return _name.substring(index, _name.length());
	}
	
	public boolean isImgIcon() {
		for(String ext : extentionList) {
			if(ext.equalsIgnoreCase(this.extention)) {
				return true;
			}
		}
		return false;
	}
	
	public Integer getDealerId() {
		return this.dealerId;
	}

	
	// MultipartFileの拡張、以下だけ有効にしておく
	public boolean isEmpty() {
		return this.imgIcon.isEmpty();
	}
	public long getSize() {
		return this.imgIcon.getSize();
	}
	public void transferTo(File dest) throws IllegalStateException, IOException{
		this.imgIcon.transferTo(dest);
	}
	
}
