package com.binance4j.websocket.payload;

import java.util.List;

import com.binance4j.core.market.OrderBookEntry;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Top bids and asks
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MiniDepthPayload {
    /**
     * The last update id
     */
    private Long lastUpdateId;
    /**
     * Bids
     */
    private List<OrderBookEntry> bids;
    /**
     * Asks
     */
    private List<OrderBookEntry> asks;
}
