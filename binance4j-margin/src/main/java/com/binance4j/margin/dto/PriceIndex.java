package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A symbol price index.
 * 
 * @param calculationTime The last price calculation timestamp in ms.
 * @param price           The price.
 * @param symbol          The asset pair.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PriceIndex(
		/** The last price calculation timestamp in ms. */
		@JsonProperty("calcTime") long calculationTime,
		/** The price. */
		String price,
		/** The asset pair. */
		String symbol) {
}
