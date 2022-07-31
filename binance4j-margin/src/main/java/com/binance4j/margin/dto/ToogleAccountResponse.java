package com.binance4j.margin.dto;

/**
 * Response after enabling/disabling isolated margin account.
 * 
 * @param success Was the request a success?
 * @param symbol  The enabled/disabled symbol.
 */
public record ToogleAccountResponse(boolean success, String symbol) {
}
