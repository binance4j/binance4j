package com.binance4j.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Defines valid range for a price based on the average of the previous trades. avgPriceMins is the number of minutes
 * the average price is calculated over. 0 means the last price is used.
 * 
 * @param multiplierUp   Multiplier up.
 * @param multiplierDown Multiplier down.
 * @param avgPriceMins   Weighted average price.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a> *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PercentPriceFilter(
		/** Multiplier up. */
		BigDecimal multiplierUp,
		/** Multiplier down. */
		BigDecimal multiplierDown,
		/** Weighted average price. */
		BigDecimal avgPriceMins) {
}