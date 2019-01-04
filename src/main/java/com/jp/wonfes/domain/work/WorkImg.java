package com.jp.wonfes.domain.work;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.base.Strings;
import com.jp.wonfes.common.WfsAbstractFile;
import com.jp.wonfes.common.WfsApplicationConf;

public class WorkImg extends WfsAbstractFile {

	@Autowired
	WfsApplicationConf wfsApplicationConf;

	private Integer dealerId;
	private Integer productId;
	private Integer seq;

	private String _dealerId;
	private String _productId;
	private String _seq;
	private MultipartFile multiFile;

	private static final String prefix = "p_";
	private String extention;
	private String fileName;

	public WorkImg(Integer dealerId, Integer productId, Integer seq, MultipartFile multiFile) {
		super();
		this.dealerId = dealerId;
		this.productId = productId;
		this.seq = seq;

		this.multiFile = multiFile;
		this._dealerId = String.valueOf(dealerId);
		this._productId = String.valueOf(productId);
		this._seq = String.valueOf(seq);
		this.extention = this.getExtention(multiFile.getOriginalFilename());
		// ファイルが空の場合、ファイル名は空文字を設定する
		this.fileName = this.isEmpty() ? ""
				: prefix + _dealerId + "_" + _productId + "_" + _seq + period + this.extention;
	}

	public Integer getDealerId() {
		return new Integer(dealerId);
	}

	public Integer getProductId() {
		return new Integer(productId);
	}

	public Integer getSeq() {
		return new Integer(seq);
	}

	/**
	 * ファイル名のみ（拡張子付き）<br>
	 * 保存先のファイルパスは含まない
	 * 
	 * @return
	 */
	public String getFileName() {
		return this.fileName;
	}

//	public String getSaveFold() {
//		return wfsApplicationConf.getWfsImgUrl() + this._dealerId + "/";
//	}
//	/**
//	 * ファイル名のみ（拡張子付き）<br>
//	 * 保存先のファイルパスを含む
//	 * @return
//	 */
//	public String getSaveFileName() {
//		return getSaveFold() + this.fileName;
//	}
//	public File getSaveFile() {
//		return new File(this.getSaveFileName());
//	}

	/**
	 * 作品画像の拡張子として許可されたものであるかどうかを判定する
	 * 
	 * @return 許可されている場合TRUE,そうでない場合FALSE
	 */
	public boolean isAllowExtention() {
		if (this.extention == "") {
			return false;
		}
		for (String ext : extentionList) {
			if (ext.equalsIgnoreCase(this.extention)) {
				return true;
			}
		}
		return false;
	}

	// MultipartFileの拡張、以下だけ有効にしておく
	public boolean isEmpty() {
		return this.multiFile.isEmpty();
	}

	public long getSize() {
		return this.multiFile.getSize();
	}

	public void transferTo(File dest) throws IllegalStateException, IOException {
		this.multiFile.transferTo(dest);
	}
	
	// 便利クラス
	/**
	 * 引数をもとに作品画像ファイル名を作成し返却する
	 * ex. p1_1_1.jpg
	 * @param dealerId
	 * @param productId
	 * @param seq
	 * @param extention
	 * @return
	 */
	public static String makeWorkImgFileName(Integer dealerId, Integer productId, Integer seq, String extention) {
		String _extention = Strings.isNullOrEmpty(extention) ? "" : "." + extention;
		return prefix + String.valueOf(dealerId) + "_" + String.valueOf(productId) + "_" + String.valueOf(seq) + _extention;
	}
	/**
	 * 引数をもとに作品画像ファイル名（拡張子なし）を作成し返却する
	 * ex. p1_1_1
	 * @param dealerId
	 * @param productId
	 * @param seq
	 * @return
	 */
	public static String makeWorkImgFileNameExcludeExtention(Integer dealerId, Integer productId, Integer seq) {
		return makeWorkImgFileName(dealerId, productId, seq, "");
	}

}
