package com.binance4j.market.dto;

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
		String bidMultiplierUp,
		/** Bid multiplier down. */
		String bidMultiplierDown,
		/** Ask multiplier up. */
		String askMultiplierUp,
		/** Ask multiplier down. */
		String askMultiplierDown,
		/** Weighted average price. */
		String avgPriceMins) {
}