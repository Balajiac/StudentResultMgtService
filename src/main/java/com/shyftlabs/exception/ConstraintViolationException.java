package com.shyftlabs.exception;

public class ConstraintViolationException extends MyBaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2384344918505649699L;

	public ConstraintViolationException(String errorCode, Throwable ex) {
		super(errorCode, ex);
	}

	public ConstraintViolationException(String errorCode) {
		super(errorCode);
	}
}
