package com.binance4j.web.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.binance4j.core.exception.ApiException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ApiException.class)
	protected ResponseEntity<ApiExceptionResponse> handleAPiException(ApiException e, WebRequest request) {
		return ResponseEntity.status(400).body(new ApiExceptionResponse(e.getCode(), e.getMessage()));
	}
}
