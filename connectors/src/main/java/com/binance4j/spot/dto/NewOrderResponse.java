package com.binance4j.spot.dto;

import java.util.List;

import com.binance4j.spot.client.SpotClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * [SpotClient.newOrder] response.
 * 
 * @property symbol              Trading pair to trade.
 * @property orderId             Order id.
 * @property orderListId         Order list id.
 * @property clientOrderId       Client order id.
 * @property transactTime        Order transaction timestamp.
 * @property price               Price of trade.
 * @property origQty             Original traded quantity.
 * @property executedQty         Current executed quantity.
 * @property cummulativeQuoteQty Opposite coin quantity.
 * @property status              Order status.
 * @property timeInForce         How long the order will remain active.
 * @property type                Order type.
 * @property side                Order side.
 * @property fills               List of trades that partially of fully filled the
 *                            order.
 */
@ApiModel("New order response.")
data class NewOrderResponse(
@ApiModelProperty("Trading pair to trade.")
 val symbol : String,
@ApiModelProperty("Order id.")
 val orderId : Long,
@ApiModelProperty("Order list id.")
 val orderListId : Long,
@ApiModelProperty("Client order id.")
 val clientOrderId : String,
@ApiModelProperty("Order transaction timestamp.")
 val transactTime : Long,
@ApiModelProperty("Price of trade.")
 val price : String,
@ApiModelProperty("Original traded quantity.")
 val origQty : String,
@ApiModelProperty("Current executed quantity.")
 val executedQty : String,
@ApiModelProperty("Opposite coin quantity.")
 val cummulativeQuoteQty : String,
@ApiModelProperty("Order status.")
 val status : String,
@ApiModelProperty("How long the order will remain active.")
 val timeInForce : String,
@ApiModelProperty("Order type.")
 val type : String,
@ApiModelProperty("Order side.")
 val side : String,
@ApiModelProperty("List of trades that partially of fully filled the order.") List<OrderTrade> fills)
{
}
