package com.binance4j.core.exception;

public class NotFoundException extends ApiException {

    public NotFoundException() {
        super(404, "Not Found");
    }

}
