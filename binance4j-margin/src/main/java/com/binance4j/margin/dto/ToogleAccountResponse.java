package com.binance4j.margin.dto;

/**
 * Response after enabling/disabling isolated margin account.
 * 
 * @param success Was the request a success?
 * @param symbol  The enabled/disabled symbol.
 */
public record ToogleAccountResponse(
		/** Was the request a success? */
		boolean success,
		/** The enabled/disabled symbol. */
		String symbol) {
}
