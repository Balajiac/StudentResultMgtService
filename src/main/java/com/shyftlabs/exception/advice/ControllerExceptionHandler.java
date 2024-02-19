package com.shyftlabs.exception.advice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.shyftlabs.constants.ErrorConstants;
import com.shyftlabs.exception.ConstraintViolationException;
import com.shyftlabs.exception.MyServerException;
import com.shyftlabs.exception.MyValidationException;
import com.shyftlabs.exception.model.ErrorMessage;

/**
 * 
 */
@ControllerAdvice
public class ControllerExceptionHandler {
	
	private ResourceBundle bundle = ResourceBundle.getBundle("error-messages", Locale.getDefault());

	@ExceptionHandler(value = {SQLIntegrityConstraintViolationException.class})
	public ResponseEntity<List<ErrorMessage>> sqlIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex, WebRequest request) {
		return new ResponseEntity<List<ErrorMessage>>(getMessage(ErrorConstants.DB_CONSTAINT_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = {ConstraintViolationException.class})
	public ResponseEntity<List<ErrorMessage>> constraintViolationException(ConstraintViolationException ex, WebRequest request) {
		return new ResponseEntity<List<ErrorMessage>>(getMessage(ex.getErrorCode()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = {MyServerException.class})
	public ResponseEntity<List<ErrorMessage>> myServerException(MyServerException ex, WebRequest request) {
		return new ResponseEntity<List<ErrorMessage>>(getMessage(ex.getErrorCode()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = {MyValidationException.class})
	public ResponseEntity<List<ErrorMessage>> myValidationException(MyValidationException ex, WebRequest request) {
		return new ResponseEntity<List<ErrorMessage>>(getMessage(ex.getErrorCodes()), HttpStatus.BAD_REQUEST);
	}
	
	private List<ErrorMessage> getMessage(String errorCode) {
		return Arrays.asList(getErrorMessage(errorCode));
	}
	
	private ErrorMessage getErrorMessage(String errorCode) {
		return new ErrorMessage(errorCode, bundle.getString(errorCode));
	}
	
	private List<ErrorMessage> getMessage(List<String> errorCodes) {
		return errorCodes.stream().map(errorCode -> getErrorMessage(errorCode)).collect(Collectors.toList());
	}

}
