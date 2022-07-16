package com.binance4j.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Defines the price rules for a symbol.
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PriceFilter(
		/** The minimum price/stopPrice allowed. Disabled on minPrice == 0. */
		BigDecimal minPrice,

		/** The maximum price/stopPrice allowed. Disabled on maxPrice == 0. */
		BigDecimal maxPrice,

		/**
		 * The intervals that a price/stopPrice can be increased/decreased by. Disabled on tickSize == 0.
		 */
		BigDecimal tickSize) {
}