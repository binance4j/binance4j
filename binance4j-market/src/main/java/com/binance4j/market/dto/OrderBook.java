package com.binance4j.market.dto;

import java.util.List;

import com.binance4j.core.dto.OrderBookEntry;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The market depth
 * 
 * @param lastUpdateId Last update id of this order book.
 * @param bids         List of bids (price/qty).
 * @param asks         List of asks (price/qty).
 */
@ApiModel("")
public record OrderBook(@ApiModelProperty("") long lastUpdateId, @ApiModelProperty("") List<OrderBookEntry> bids,
		@ApiModelProperty("") List<OrderBookEntry> asks) {
}
