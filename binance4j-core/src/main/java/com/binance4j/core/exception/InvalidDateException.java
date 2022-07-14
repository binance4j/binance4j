package com.binance4j.core.exception;

/** TODO JAVADOC */
public class InvalidDateException extends ApiException {

    public InvalidDateException() {
        super(-500, "Date is invalid");
    }

}
