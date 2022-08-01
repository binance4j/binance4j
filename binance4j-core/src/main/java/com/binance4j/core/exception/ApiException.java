package com.binance4j.core.exception;

/** An exception which can occur while invoking methods of the Binance API. */
public class ApiException extends Exception {
	/** The error code */
	final String code;
	/** The error code explanation */
	final ApiErrorCode errorCode;

	/**
	 * @param code    The API response code.
	 * @param message The API response message.
	 */
	public ApiException(String code, String message) {
		super(message);
		this.code = code;
		this.errorCode = ApiErrorCode.valueOf(code);
	}

	/**
	 * @param code    The API response code.
	 * @param message The API response message.
	 */
	public ApiException(ApiErrorCode code, String message) {
		super(message);
		this.code = code.toString();
		this.errorCode = code;
	}

	/**
	 * @param error The API response error.
	 */
	public ApiException(ApiError error) {
		this(Integer.toString(error.getCode()), error.getMsg());
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the errorCode
	 */
	public ApiErrorCode getErrorCode() {
		return errorCode;
	}
}