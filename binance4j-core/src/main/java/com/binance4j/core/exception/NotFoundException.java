package com.binance4j.core.exception;

/** Thrown when data was not found */
public class NotFoundException extends ApiException {
	/** Constructor */
	public NotFoundException() {
		super(404, "Not Found");
	}
}
