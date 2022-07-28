package com.binance4j.market.dto;

/**
 * A wrapper for the server time
 * 
 * @param serverTime The server time in ms.
 */
public record ServerTimeResponse(
		/** The server time in ms. */
		long serverTime) {
}