package com.binance4j.market.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * * Defines the price rules for a symbol.
 * 
 * @param minPrice The minimum price/stopPrice allowed. Disabled on minPrice == 0.
 * @param maxPrice The maximum price/stopPrice allowed. Disabled on maxPrice == 0.
 * @param tickSize The intervals that a price/stopPrice can be increased/decreased by. Disabled on tickSize == 0.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PriceFilter(
		/** The minimum price/stopPrice allowed. Disabled on minPrice == 0. */
		String minPrice,
		/** The maximum price/stopPrice allowed. Disabled on maxPrice == 0. */
		String maxPrice,
		/** The intervals that a price/stopPrice can be increased/decreased by. Disabled on tickSize == 0. */
		String tickSize) {
}