package com.jp.wonfes.common;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class WfsImgIcon extends WfsAbstractFile {
	private static final String img_icon_prefix = "i_";

	private final MultipartFile imgIcon;
	private final Integer dealerId;
	private final String extention;

	public WfsImgIcon(MultipartFile imgIcon, Integer dealerId) {
		super();
		this.imgIcon = imgIcon;
		this.dealerId = dealerId;
		this.extention = this.getWfsExtention();
		
		// TODO 画像アイコンであることのチェックを行いたい
		// 拡張子がなければエラー
		// 拡張子が画像アイコンでなければエラー
		// アイコンファイル名が拡張子を含め10桁を超える場合（テーブル定義を拡張したほうがいい）
		
	}
	
	/**
	 * アイコン画像の名称を返却する
	 * @return アイコン画像の名称
	 */
	public String getWfsImgIconName() {
		return img_icon_prefix + this.dealerId + period + this.extention;
	}
	
	//拡張子がない場合はエラーにせず空文字を設定する
	private String getWfsExtention() {
		if (!this.isEmpty()) {
			String _name = this.imgIcon.getOriginalFilename();
			int index = _name.lastIndexOf(".");
			if (index == -1) {
				return "";
				// throw new IllegalStateException("アイコン画像に拡張子がありません");
			}
			return _name.substring(index + 1, _name.length());
		}
		return "";
	}
	
	/**
	 * アイコン画像拡張子であるかどうかを判定する
	 * @return アイコン画像拡張子である場合TRUE,そうでない場合FALSE
	 */
	public boolean isImgIcon() {
		if(this.extention=="") {return false;}
		for(String ext : extentionList) {
			if(ext.equalsIgnoreCase(this.extention)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * アイコン画像と対応するディーラIDを返却する
	 * @return
	 */
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
