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
@JsonProperty("symbol") var symbol:String?=null,
@ApiModelProperty("Order id.")
@JsonProperty("orderId") var orderId:Long?=null,
@ApiModelProperty("Order list id.")
@JsonProperty("orderListId") var orderListId:Long?=null,
@ApiModelProperty("Client order id.")
@JsonProperty("clientOrderId") var clientOrderId:String?=null,
@ApiModelProperty("Order transaction timestamp.")
@JsonProperty("transactTime") var transactTime:Long?=null,
@ApiModelProperty("Price of trade.")
@JsonProperty("price") var price:String?=null,
@ApiModelProperty("Original traded quantity.")
@JsonProperty("origQty") var origQty:String?=null,
@ApiModelProperty("Current executed quantity.")
@JsonProperty("executedQty") var executedQty:String?=null,
@ApiModelProperty("Opposite coin quantity.")
@JsonProperty("cummulativeQuoteQty") var cummulativeQuoteQty:String?=null,
@ApiModelProperty("Order status.")
@JsonProperty("status") var status:String?=null,
@ApiModelProperty("How long the order will remain active.")
@JsonProperty("timeInForce") var timeInForce:String?=null,
@ApiModelProperty("Order type.")
@JsonProperty("type") var type:String?=null,
@ApiModelProperty("Order side.")
@JsonProperty("side") var side:String?=null,
@ApiModelProperty("List of trades that partially of fully filled the order.") List<OrderTrade> fills)
{
}
