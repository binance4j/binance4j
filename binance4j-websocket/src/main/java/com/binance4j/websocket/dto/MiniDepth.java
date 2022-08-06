package com.binance4j.websocket.dto;

import java.util.List;

import com.binance4j.core.dto.OrderBookEntry;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Top bids and asks.
 * 
 * @param lastUpdateId The last update id.
 * @param bids         Bids.
 * @param asks         Asks.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("")
public record MiniDepth(@ApiModelProperty("") Long lastUpdateId, @ApiModelProperty("") List<OrderBookEntry> bids,
		@ApiModelProperty("") List<OrderBookEntry> asks) {
}
