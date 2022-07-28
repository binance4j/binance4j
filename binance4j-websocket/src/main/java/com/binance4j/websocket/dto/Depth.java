package com.binance4j.websocket.dto;

import java.util.List;

import com.binance4j.core.dto.OrderBookEntry;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The symbol order book.
 * 
 * @param eventType     The event type.
 * @param eventTime     The timestamp.
 * @param symbol        The trading pair.
 * @param firstUpdateId First update id.
 * @param finalUpdateId Last update id.
 * @param bids          The offers.
 * @param asks          The demands.
 */

public record Depth(
		/** The event type. */
		@JsonProperty("e") String eventType,
		/** The timestamp. */
		@JsonProperty("E") Long eventTime,
		/** The trading pair. */
		@JsonProperty("s") String symbol,
		/** First update id. */
		@JsonProperty("U") Long firstUpdateId,
		/** Last update id. */
		@JsonProperty("u") Long finalUpdateId,
		/** The offers. */
		@JsonProperty("b") List<OrderBookEntry> bids,
		/** The demands. */
		@JsonProperty("a") List<OrderBookEntry> asks) {
}