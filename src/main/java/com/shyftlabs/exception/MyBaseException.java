package com.shyftlabs.exception;

public class MyBaseException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6327509123039171598L;
	
	private final String errorCode;

	public MyBaseException(String errorCode, Throwable ex) {
		super(ex);
		this.errorCode = errorCode;
	}

	public MyBaseException(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

}
