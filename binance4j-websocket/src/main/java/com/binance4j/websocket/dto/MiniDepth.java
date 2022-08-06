package com.binance4j.websocket.dto;

import java.util.List;

import com.binance4j.core.dto.OrderBookEntry;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Top bids and asks.
 * 
 * @param lastUpdateId Last update id.
 * @param bids         Bids.
 * @param asks         Asks.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Top bids and asks.")
public record MiniDepth(@ApiModelProperty("Last update id.") Long lastUpdateId, @ApiModelProperty("Bids.") List<OrderBookEntry> bids,
		@ApiModelProperty("Asks.") List<OrderBookEntry> asks) {
}
