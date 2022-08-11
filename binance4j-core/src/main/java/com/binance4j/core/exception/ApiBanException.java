package com.binance4j.core.exception;

/** Thrown when Banned by API for too many API rate limit excess. */
public class ApiBanException extends ApiException {
	/** Constructor */
	public ApiBanException() {
		super(418, "IP has been auto-banned for continuing to send requests after receiving 429 codes");
	}
}
