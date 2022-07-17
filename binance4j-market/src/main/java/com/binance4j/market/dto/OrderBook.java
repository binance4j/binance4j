package com.binance4j.market.dto;

import java.util.List;

import com.binance4j.core.dto.OrderBookEntry;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The market depth
 * 
 * @param lastUpdateId Last update id of this order book.
 * @param bids         List of bids (price/qty).
 * @param asks         List of asks (price/qty).
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderBook(
		/** Last update id of this order book. */
		long lastUpdateId,
		/** List of bids (price/qty). */
		List<OrderBookEntry> bids,
		/** List of asks (price/qty). */
		List<OrderBookEntry> asks) {
}
