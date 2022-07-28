package com.binance4j.market.dto;

/**
 * Current average price for a symbol.
 * 
 * @param mins  Mins.
 * @param price The average price of the asset.
 */
public record AveragePrice(
		/** Mins */
		int mins,
		/** The average price of the asset. */
		String price) {
}
