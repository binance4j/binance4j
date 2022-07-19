package com.binance4j.websocket.dto;

import java.util.List;

import com.binance4j.core.dto.OrderBookEntry;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Top bids and asks */

@JsonIgnoreProperties(ignoreUnknown = true)
public record MiniDepth(
		/** The last update id. */
		Long lastUpdateId,
		/** Bids. */
		List<OrderBookEntry> bids,
		/** Asks. */
		List<OrderBookEntry> asks) {
}
