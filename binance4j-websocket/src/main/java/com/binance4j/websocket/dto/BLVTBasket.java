package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Net asset value basket.
 * 
 * @param symbol   Futures symbol.
 * @param position Position.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record BLVTBasket(
		/** Futures symbol. */
		@JsonProperty("s") String symbol,
		/** Position. */
		@JsonProperty("n") long position) {
}
