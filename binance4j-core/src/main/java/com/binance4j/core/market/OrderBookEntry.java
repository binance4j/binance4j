package com.binance4j.core.market;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * An order book entry consisting of price and quantity.
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFormat(shape = Shape.ARRAY)
@JsonPropertyOrder()
public class OrderBookEntry {
	/**
	 * The price
	 */
	private BigDecimal price;
	/**
	 * The quantity
	 */
	@JsonProperty("qt")
	private BigDecimal quantity;
}
