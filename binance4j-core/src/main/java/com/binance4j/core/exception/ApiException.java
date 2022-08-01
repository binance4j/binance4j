package com.binance4j.core.exception;

/** An exception which can occur while invoking methods of the Binance API. */
public class ApiException extends Exception {
	/** The error code */
	final int code;

	/**
	 * @param code    The API response code.
	 * @param message The API response message.
	 */
	public ApiException(int code, String message) {
		super(message);
		this.code = code;
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
}