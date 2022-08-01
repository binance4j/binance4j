package com.binance4j.core.exception;

/** Thrown when a deserialization has failed */
public class DeserializationException extends ApiException {
	/** Constructor */
	public DeserializationException() {
		super(-1007, "Deserialization failed");
	}
}