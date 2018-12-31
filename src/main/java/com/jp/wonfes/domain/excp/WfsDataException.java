package com.jp.wonfes.domain.excp;

/**
 * Daoクラス利用時のエラーに対応
 * FIXME 不要なら削除する
 * @author rock
 *
 */
public class WfsDataException extends Exception{
	private static final long serialVersionUID = 1L;

	public WfsDataException(String msg) {
		super(msg);
	}
}
