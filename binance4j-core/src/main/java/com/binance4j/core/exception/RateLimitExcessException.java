package com.binance4j.core.exception;

/** Thrown when rate limit is exceeded. */
public class RateLimitExcessException extends ApiException {
	/** Constructor */
	public RateLimitExcessException() {
		super(429, "Request rate limit exceeded");
	}
}
