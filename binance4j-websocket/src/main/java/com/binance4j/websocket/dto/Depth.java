package com.binance4j.websocket.dto;

import java.util.List;

import com.binance4j.core.dto.OrderBookEntry;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The symbol order book */

@JsonIgnoreProperties(ignoreUnknown = true)
public record Depth(/** The event type. */
@JsonProperty("e") String eventType,
		/** The timestamp. */
		@JsonProperty("E") Long eventTime,
		/** The trading pair. */
		@JsonProperty("s") String symbol,
		/** first update id. */
		@JsonProperty("U") Long firstUpdateId,
		/** last update id. */
		@JsonProperty("u") Long finalUpdateId,
		/** The offers. */
		@JsonProperty("b") List<OrderBookEntry> bids,
		/** The demands. */
		@JsonProperty("a") List<OrderBookEntry> asks) {
}