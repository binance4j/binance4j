package com.binance4j.market.depth;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Represents the best price/qty on the order book for a given symbol.
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookTicker {
	/**
	 * Ticker symbol.
	 */
	private String symbol;
	/**
	 * Bid price.
	 */
	private String bidPrice;
	/**
	 * Bid quantity
	 */
	@JsonProperty("bidQty")
	private String bidQuantity;
	/**
	 * Ask price.
	 */
	private String askPrice;
	/**
	 * Ask quantity.
	 */
	@JsonProperty("askQty")
	private String askQuantity;
}