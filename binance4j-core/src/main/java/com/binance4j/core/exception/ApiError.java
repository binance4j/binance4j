package com.binance4j.core.exception;

/** API response error containing a code and a message. */
public class ApiError {
	/** The error code. */
	private int code;
	/** The error message. */
	private String msg;

	/**
	 * Constructor
	 */
	public ApiError() {
	}

	/**
	 * @param code The error code.
	 * @param msg  The error message.
	 */
	public ApiError(int code, String msg) {
		this.msg = msg;
		this.code = code;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
}