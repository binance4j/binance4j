package com.binance4j.core.exception;

public class DeserializationException extends ApiException {

    public DeserializationException() {
        super(-1007, "Deserialization failed");
    }

}
