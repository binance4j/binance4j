package com.binance4j.spot.dto;

import java.util.List;

import com.binance4j.spot.client.SpotClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * {@link SpotClient#newOrder} response.
 * 
 * @param symbol              Trading pair to trade.
 * @param orderId             Order id.
 * @param orderListId         Order list id.
 * @param clientOrderId       Client order id.
 * @param transactTime        Order transaction timestamp.
 * @param price               Price of trade.
 * @param origQty             Original traded quantity.
 * @param executedQty         Current executed quantity.
 * @param cummulativeQuoteQty Opposite coin quantity.
 * @param status              Order status.
 * @param timeInForce         How long the order will remain active.
 * @param type                Order type.
 * @param side                Order side.
 * @param fills               List of trades that partially of fully filled the
 *                            order.
 */
@ApiModel("New order response.")
public record NewOrderResponse(@ApiModelProperty("Trading pair to trade.") String symbol,
		@ApiModelProperty("Order id.") long orderId,
		@ApiModelProperty("Order list id.") long orderListId,
		@ApiModelProperty("Client order id.") String clientOrderId,
		@ApiModelProperty("Order transaction timestamp.") long transactTime,
		@ApiModelProperty("Price of trade.") String price,
		@ApiModelProperty("Original traded quantity.") String origQty,
		@ApiModelProperty("Current executed quantity.") String executedQty,
		@ApiModelProperty("Opposite coin quantity.") String cummulativeQuoteQty,
		@ApiModelProperty("Order status.") String status,
		@ApiModelProperty("How long the order will remain active.") String timeInForce,
		@ApiModelProperty("Order type.") String type,
		@ApiModelProperty("Order side.") String side,
		@ApiModelProperty("List of trades that partially of fully filled the order.") List<OrderTrade> fills) {
}
