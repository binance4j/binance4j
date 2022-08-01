package com.binance4j.core.exception;

/** Thrown when given date is invalid */
public class InvalidDateException extends ApiException {
	/** Constructor */
	public InvalidDateException() {
		super(-500, "Date is invalid");
	}
}