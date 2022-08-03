package com.binance4j.websocket.dto;

import java.util.List;

import com.binance4j.core.dto.OrderBookEntry;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public record Depth(@JsonProperty("e") String eventType, @JsonProperty("E") Long eventTime, @JsonProperty("s") String symbol,
		@JsonProperty("U") Long firstUpdateId, @JsonProperty("u") Long finalUpdateId, @JsonProperty("b") List<OrderBookEntry> bids,
		@JsonProperty("a") List<OrderBookEntry> asks) {
}