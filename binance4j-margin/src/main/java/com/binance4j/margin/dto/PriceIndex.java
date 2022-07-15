package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** A symbol price index. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PriceIndex(
		/** The last price calculation timestamp in ms. */
		long calcTime,
		/** The price. */
		BigDecimal price,
		/** The asset pair. */
		String symbol) {
}
