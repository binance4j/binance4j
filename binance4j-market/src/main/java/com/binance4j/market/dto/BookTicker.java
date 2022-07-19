package com.binance4j.market.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the best price/quantity on the order book for a given symbol.
 * 
 * @param symbol      Ticker symbol.
 * @param bidPrice    Bid price.
 * @param bidQuantity Bid quantity.
 * @param askPrice    Ask price.
 * @param askQuantity Ask quantity.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record BookTicker(
		/** Ticker symbol. */
		String symbol,
		/** Bid price. */
		String bidPrice,
		/** Bid quantity. */
		@JsonProperty("bidQty") String bidQuantity,
		/** Ask price. */
		String askPrice,
		/** Ask quantity. */
		@JsonProperty("askQty") String askQuantity) {
}