package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;

/**
 * BookTickerEvent event for a symbol. Pushes any update to the best bid or ask price or quantity in real-time for a
 * specified symbol.
 * 
 * @param updateId    The update id.
 * @param symbol      The trading pair.
 * @param bidPrice    The bid price.
 * @param bidQuantity The bid quantity.
 * @param askPrice    The ask price.
 * @param askQuantity The ask quantity.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("")
public record BookTicker(@JsonProperty("u") Long updateId, @JsonProperty("s") String symbol, @JsonProperty("b") String bidPrice,
		@JsonProperty("B") String bidQuantity, @JsonProperty("a") String askPrice, @JsonProperty("A") String askQuantity) {
}