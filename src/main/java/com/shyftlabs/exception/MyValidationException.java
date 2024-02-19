package com.shyftlabs.exception;

import java.util.Arrays;
import java.util.List;

public class MyValidationException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5205736147963442701L;
	
	private final List<String> errorCodes;

	public MyValidationException(String errorCode, Throwable ex) {
		this(Arrays.asList(errorCode), ex);
	}

	public MyValidationException(String errorCode) {
		this(Arrays.asList(errorCode));
	}

	public MyValidationException(List<String> errorCodes, Throwable ex) {
		super(ex);
		this.errorCodes = errorCodes;
	}

	public MyValidationException(List<String> errorCodes) {
		this.errorCodes = errorCodes;
	}
	
	public List<String> getErrorCodes() {
		return errorCodes;
	}

}
