package com.binance4j.market.dto;

import java.util.List;

import com.binance4j.core.dto.OrderBookEntry;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** The market depth */
@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderBook(
		/** Last update id of this order book. */
		Long lastUpdateId,
		/** List of bids (price/qty). */
		List<OrderBookEntry> bids,
		/** List of asks (price/qty). */
		List<OrderBookEntry> asks) {
}
