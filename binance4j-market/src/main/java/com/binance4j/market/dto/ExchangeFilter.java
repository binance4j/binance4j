package com.binance4j.market.dto;

/**
 * Trading rules of the exchange.
 * 
 * @param filterType The filter type.
 * @param limit      The filter limit.
 */
public record ExchangeFilter(
		/** The filter type. */
		ExchangeFilterType filterType,
		/** The filter limit. */
		int limit) {
}