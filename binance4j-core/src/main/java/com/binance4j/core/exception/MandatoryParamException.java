package com.binance4j.core.exception;

/** Thrown when a mandatory param is missing in a request. */
public class MandatoryParamException extends ApiException {
	/** Constructor */
	public MandatoryParamException() {
		super(-3000, "A mandatory param is missing in the request");
	}
}
