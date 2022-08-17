package com.binance4j.web.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.binance4j.core.exception.ApiException;

/** ApiException henadler */
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * 
	 * @param exception The exception thrown by the Binance API
	 * @return A wrapper of the Binance ApiException.
	 */
	@ExceptionHandler(ApiException.class)
	protected ResponseEntity<ApiExceptionResponse> handleAPiException(ApiException exception) {
		return ResponseEntity.status(400).body(new ApiExceptionResponse(exception.getCode(), exception.getMessage()));
	}
}
