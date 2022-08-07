package com.binance4j.web.exception;

/**
 * ApiException wrapper sent to client when captured by {@link ApiExceptionHandler}
 * 
 * @param code    The exception code.
 * @param message The exception message.
 */
public record ApiExceptionResponse(int code, String message) {

}
