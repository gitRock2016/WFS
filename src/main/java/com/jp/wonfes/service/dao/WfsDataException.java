package com.jp.wonfes.service.dao;

/**
 * Daoクラス利用時のエラーに対応
 * @author rock
 *
 */
public class WfsDataException extends Exception {

	private static final long serialVersionUID = 1L;

	public WfsDataException(String msg) {
		super(msg);
	}

}
