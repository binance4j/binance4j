package com.binance4j.core.security;

/**
 * Runtime exception thrown if {@link HmacSHA256Signer} can't sign the API keys
 */
public class UnableToSignException extends RuntimeException {

    /**
     * Constructor
     * 
     * @param e The original exception
     */
    public UnableToSignException(Exception e) {
        super("Unable to sign message.", e);
    }

}
