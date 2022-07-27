package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * An order book entry consisting of price and quantity.
 * 
 * @param price    The price.
 * @param quantity The quantity.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFormat(shape = Shape.ARRAY)
@JsonPropertyOrder()
public record OrderBookEntry(
		/** The price. */
		String price,
		/** The quantity. */
		@JsonProperty("qt") String quantity) {
}