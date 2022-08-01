package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * An order book entry consisting of price and quantity.
 * 
 * @param price The price.
 * @param qt    The quantity.
 */
@JsonFormat(shape = Shape.ARRAY)
@JsonPropertyOrder()
public record OrderBookEntry(String price, String qt) {
}