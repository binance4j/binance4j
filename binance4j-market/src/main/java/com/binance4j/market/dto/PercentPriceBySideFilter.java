package com.binance4j.market.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Defines the valid range for the price based on the lastPrice of the symbol. There is a different range depending on
 * whether the order is placed on the BUY side or the SELL side.
 * 
 * @param bidMultiplierUp   Bid multiplier up.
 * @param bidMultiplierDown Bid multiplier down.
 * @param askMultiplierUp   Ask multiplier up.
 * @param askMultiplierDown Ask multiplier down.
 * @param avgPriceMins      Weighted average price.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a> *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PercentPriceBySideFilter(
		/** Bid multiplier up. */
		BigDecimal bidMultiplierUp,
		/** Bid multiplier down. */
		BigDecimal bidMultiplierDown,
		/** Ask multiplier up. */
		BigDecimal askMultiplierUp,
		/** Ask multiplier down. */
		BigDecimal askMultiplierDown,
		/** Weighted average price. */
		BigDecimal avgPriceMins) {
}