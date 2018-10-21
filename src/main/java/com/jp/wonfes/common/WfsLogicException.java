package com.jp.wonfes.common;

public class WfsLogicException extends Exception {

	private static final long serialVersionUID = -8943370827545987082L;

	public WfsLogicException() {
		super();
	}
	
	public WfsLogicException(String string) {
		super(string);
	}

	public WfsLogicException(String message, Throwable cause) {
		super(message, cause);
	}

	public WfsLogicException(Throwable cause) {
		super(cause);
	}

}
