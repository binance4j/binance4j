package com.binance4j.spot.dto;

import java.util.List;

import com.binance4j.spot.client.SpotClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * {@link SpotClient#newOrder} response.
 * 
 * @param symbol              The trading pair to trade.
 * @param orderId             The order id.
 * @param orderListId         The order list id.
 * @param clientOrderId       The client order id.
 * @param transactTime        The order transaction timestamp.
 * @param price               The price of trade.
 * @param origQty             The original traded quantity.
 * @param executedQty         The current executed quantity.
 * @param cummulativeQuoteQty The opposite coin quantity.
 * @param status              The order status.
 * @param timeInForce         How long the order will remain active.
 * @param type                The order type.
 * @param side                The order side.
 * @param fills               The list of trades that partially of fully filled the order.
 */
@ApiModel("")
public record NewOrderResponse(@ApiModelProperty("") String symbol, @ApiModelProperty("") long orderId, @ApiModelProperty("") long orderListId,
		@ApiModelProperty("") String clientOrderId, @ApiModelProperty("") long transactTime, @ApiModelProperty("") String price,
		@ApiModelProperty("") String origQty, @ApiModelProperty("") String executedQty, @ApiModelProperty("") String cummulativeQuoteQty,
		@ApiModelProperty("") String status, @ApiModelProperty("") String timeInForce, @ApiModelProperty("") String type, @ApiModelProperty("") String side,
		@ApiModelProperty("") List<OrderTrade> fills) {
}
