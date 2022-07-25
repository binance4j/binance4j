package com.binance4j.market.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Trading rules of the exchange.
 * 
 * @param filterType The filter type.
 * @param limit      The filter limit.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ExchangeFilter(
		/** The filter type. */
		ExchangeFilterType filterType,
		/** The filter limit. */
		int limit) {
}