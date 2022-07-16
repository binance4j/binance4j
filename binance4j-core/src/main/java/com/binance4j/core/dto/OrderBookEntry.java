package com.binance4j.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/** An order book entry consisting of price and quantity. */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFormat(shape = Shape.ARRAY)
@JsonPropertyOrder()
public record OrderBookEntry(
		/** The price. */
		BigDecimal price,
		/** The quantity. */
		@JsonProperty("qt") BigDecimal quantity) {
}