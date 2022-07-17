package com.binance4j.market.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Wraps a symbol and its corresponding latest price.
 * 
 * @param symbol Ticker symbol.
 * @param price  Latest price.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PriceTicker(
		/** Ticker symbol. */
		String symbol,
		/** Latest price. */
		String price) {
}
