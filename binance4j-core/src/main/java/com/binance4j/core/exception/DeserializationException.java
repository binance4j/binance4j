package com.binance4j.core.exception;

/** TODO JAVADOC */
public class DeserializationException extends ApiException {

    public DeserializationException() {
        super(-1007, "Deserialization failed");
    }

}
