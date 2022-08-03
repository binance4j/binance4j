package com.binance4j.websocket.dto;

import java.util.List;

import com.binance4j.core.dto.OrderBookEntry;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Top bids and asks.
 * 
 * @param lastUpdateId The last update id.
 * @param bids         Bids.
 * @param asks         Asks.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MiniDepth(Long lastUpdateId, List<OrderBookEntry> bids, List<OrderBookEntry> asks) {
}
