package com.binance4j.core.exception;

import com.binance4j.core.client.RestClient;

/** Runtime exception thrown if {@link RestClient} can't sign the API keys */
public class UnableToSignException extends RuntimeException {
	/** @param e The original exception */
	public UnableToSignException(Exception e) {
		super("Unable to sign message.", e);
	}
}