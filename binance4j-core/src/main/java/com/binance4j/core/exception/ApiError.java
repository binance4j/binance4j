package com.binance4j.core.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

/** API response error containing a code and a message */
@Data
@NoArgsConstructor
public class ApiError {
    /**
     * The error code.
     */
    private int code;
    /**
     * The error message.
     */
    private String msg;

    /**
     * Constructor
     * 
     * @param code The error code
     * @param msg  The error message
     */
    public ApiError(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }
}