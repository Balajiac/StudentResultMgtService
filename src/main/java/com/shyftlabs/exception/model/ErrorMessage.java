package com.shyftlabs.exception.model;

public class ErrorMessage {
	
	private final String errorCode;
	private final String errorMsg;

	public ErrorMessage(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}
