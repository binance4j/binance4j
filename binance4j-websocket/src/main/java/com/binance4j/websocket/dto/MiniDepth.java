package com.binance4j.websocket.dto;

import java.util.List;

import com.binance4j.core.dto.OrderBookEntry;

/**
 * Top bids and asks.
 * 
 * @param lastUpdateId The last update id.
 * @param bids         Bids.
 * @param asks         Asks.
 */

public record MiniDepth(
		/** The last update id. */
		Long lastUpdateId,
		/** Bids. */
		List<OrderBookEntry> bids,
		/** Asks. */
		List<OrderBookEntry> asks) {
}
