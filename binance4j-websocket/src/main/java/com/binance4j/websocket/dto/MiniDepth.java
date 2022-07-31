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
public record MiniDepth(Long lastUpdateId, List<OrderBookEntry> bids, List<OrderBookEntry> asks) {
}
