package com.binance4j.market.dto;

import java.util.List;

import com.binance4j.core.dto.OrderBookEntry;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The market depth.
 * 
 * @param lastUpdateId Last update id of this order book.
 * @param bids         List of bids (price/qty).
 * @param asks         List of asks (price/qty).
 */
@ApiModel("The market depth.")
public record OrderBook(@ApiModelProperty("Last update id of this order book.") long lastUpdateId,
		@ApiModelProperty("List of bids (price/qty).") List<OrderBookEntry> bids,
		@ApiModelProperty("List of asks (price/qty).") List<OrderBookEntry> asks) {
}
