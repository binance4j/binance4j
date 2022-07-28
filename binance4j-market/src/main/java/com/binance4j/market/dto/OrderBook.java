package com.binance4j.market.dto;

import java.util.List;

import com.binance4j.core.dto.OrderBookEntry;

/**
 * The market depth
 * 
 * @param lastUpdateId Last update id of this order book.
 * @param bids         List of bids (price/qty).
 * @param asks         List of asks (price/qty).
 */
public record OrderBook(
		/** Last update id of this order book. */
		long lastUpdateId,
		/** List of bids (price/qty). */
		List<OrderBookEntry> bids,
		/** List of asks (price/qty). */
		List<OrderBookEntry> asks) {
}
