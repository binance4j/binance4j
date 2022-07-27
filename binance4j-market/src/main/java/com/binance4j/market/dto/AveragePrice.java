package com.binance4j.market.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Current average price for a symbol.
 * 
 * @param mins  Mins.
 * @param price The average price of the asset.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AveragePrice(
		/** Mins */
		int mins,
		/** The average price of the asset. */
		String price) {
}
