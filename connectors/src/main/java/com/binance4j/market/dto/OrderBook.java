package com.binance4j.market.dto;

import java.util.List;

import com.binance4j.core.dto.OrderBookEntry;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The market depth.
 * 
 * @property lastUpdateId Last update id of this order book.
 * @property bids         List of bids (price/qty).
 * @property asks         List of asks (price/qty).
 */
@ApiModel("The market depth.")
data class OrderBook(
@ApiModelProperty("Last update id of this order book.")
 val lastUpdateId : Long,
@ApiModelProperty("List of bids (price/qty).") List<OrderBookEntry> bids,
@ApiModelProperty("List of asks (price/qty).")
List<OrderBookEntry> asks)
{
}
