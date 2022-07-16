package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Trading rules of the exchange. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ExchangeFilter(
		/** The filter type. */
		ExchangeFilterType filterType,
		/** The filter limit. */
		Integer limit) {
}