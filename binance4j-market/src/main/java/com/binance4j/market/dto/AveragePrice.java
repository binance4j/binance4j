package com.binance4j.market.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Current average price for a symbol. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AveragePrice(
		/** ??? */
		int mins,
		/** The average price of the asset. */
		BigDecimal price) {
}
