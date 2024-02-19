package com.shyftlabs.exception;

public class MyServerException extends MyBaseException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5205736147963442701L;

	public MyServerException(String errorCode, Throwable ex) {
		super(errorCode, ex);
	}

	public MyServerException(String errorCode) {
		super(errorCode);
	}

}
