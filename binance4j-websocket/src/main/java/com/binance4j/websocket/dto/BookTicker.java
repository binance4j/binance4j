package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * BookTickerEvent event for a symbol. Pushes any update to the best bid or ask price or quantity in real-time for a
 * specified symbol.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookTicker(/** The update id. */
@JsonProperty("u") Long updateId,
		/** The trading pair. */
		@JsonProperty("s") String symbol,
		/** The bid price. */
		@JsonProperty("b") String bidPrice,
		/** The bid quantity. */
		@JsonProperty("B") String bidQuantity,
		/** The ask price. */
		@JsonProperty("a") String askPrice,
		/** The ask quantity. */
		@JsonProperty("A") String askQuantity) {
}