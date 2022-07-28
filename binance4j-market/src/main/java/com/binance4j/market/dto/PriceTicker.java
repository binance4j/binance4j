package com.binance4j.market.dto;

/**
 * Wraps a symbol and its corresponding latest price.
 * 
 * @param symbol Ticker symbol.
 * @param price  Latest price.
 */
public record PriceTicker(
		/** Ticker symbol. */
		String symbol,
		/** Latest price. */
		String price) {
}
