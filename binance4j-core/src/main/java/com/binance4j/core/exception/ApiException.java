package com.binance4j.core.exception;

/** An exception which can occur while invoking methods of the Binance API. */
public class ApiException extends Exception {

	/** The error code */
	private final int code;

	/** The error code explanation */
	private final ApiErrorCode errorCode;

	/**
	 * @param code    The API response code.
	 * @param message The API response message.
	 */
	public ApiException(int code, String message) {
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
		this.code = code.getValue();
		this.errorCode = code;
	}

	/**
	 * @param error The API response error.
	 */
	public ApiException(ApiError error) {
		this(error.getCode(), error.getMsg());
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @return the errorCode
	 */
	public ApiErrorCode getErrorCode() {
		return errorCode;
	}

}