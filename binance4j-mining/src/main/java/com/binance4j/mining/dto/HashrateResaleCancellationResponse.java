package com.binance4j.mining.dto;

/**
 * @param code Code.
 * @param msg  Message.
 * @param data Cancellation success.
 */
public record HashrateResaleCancellationResponse(int code, String msg, boolean data) {
}
