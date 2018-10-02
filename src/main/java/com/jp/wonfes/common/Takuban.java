package com.jp.wonfes.common;

public class Takuban {
	private String _takuban; // 042301
	private String takuban; // 4-23-1
	private Integer ko;
	private Integer otu;
	private Integer hei;

	public Takuban(String tbn) {
		if(tbn.length()!=6) {
			// TODO エラー処理を実装すること
			System.out.println("err:長さが6でない");
		}
		String ko = tbn.substring(0, 2);
		String otu = tbn.substring(2, 4);
		String hei = tbn.substring(4, 6);
		
		Integer _ko = Integer.parseInt(ko);
		Integer _otu = Integer.parseInt(otu);
		Integer _hei = Integer.parseInt(hei);
		checkKo(_ko);
		
		this._takuban=tbn;
		this.takuban = ko + '-' + otu + '-' + hei;
		this.ko=_ko;
		this.otu=_otu;
		this.hei=_hei;
		
	}
	
	
	public String get_takuban() {
		return _takuban;
	}


	public void set_takuban(String _takuban) {
		this._takuban = _takuban;
	}


	public String getTakuban() {
		return takuban;
	}


	public void setTakuban(String takuban) {
		this.takuban = takuban;
	}


	public Integer getKo() {
		return ko;
	}


	public void setKo(Integer ko) {
		this.ko = ko;
	}


	public Integer getOtu() {
		return otu;
	}


	public void setOtu(Integer otu) {
		this.otu = otu;
	}


	public Integer getHei() {
		return hei;
	}


	public void setHei(Integer hei) {
		this.hei = hei;
	}

	/**
	 * @return 0埋めした卓番（甲-乙-丙）
	 */
	public String getTakubanPadding() {
		return String.format("%02d", ko) + '-' + String.format("%02d", otu) + '-' + String.format("%02d", hei);
	}
	
	/**
	 * 甲に対するチェック
	 * @param i
	 */
	private void checkKo(Integer i) {
		if (i < 4 || i > 9) {
			// TODO エラー処理を実装すること
			System.out.println("err:卓番の数値の範囲エラー");
		}else {
		}
	}
}
