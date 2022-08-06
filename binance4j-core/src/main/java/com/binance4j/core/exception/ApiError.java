package com.binance4j.core.exception;

/** API response error containing a code and a message. */
public class ApiError {
	/** The error code. */
	int code;
	/** The error message. */
	String msg;

	/**
	 * Constructor
	 */
	public ApiError() {
	}

	/**
	 * @param code Error code.
	 * @param msg  Error message.
	 */
	public ApiError(int code, String msg) {
		this.msg = msg;
		this.code = code;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg Msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code Code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
}