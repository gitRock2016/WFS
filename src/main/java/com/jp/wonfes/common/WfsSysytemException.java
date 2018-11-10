package com.jp.wonfes.common;

public class WfsSysytemException extends Exception {

	private static final long serialVersionUID = -8943370827545987082L;

	public WfsSysytemException() {
		super();
	}
	
	public WfsSysytemException(String string) {
		super(string);
	}

	public WfsSysytemException(String message, Throwable cause) {
		super(message, cause);
	}

	public WfsSysytemException(Throwable cause) {
		super(cause);
	}

}
