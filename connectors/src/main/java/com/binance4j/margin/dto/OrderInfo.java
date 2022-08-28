package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Trade order information.
 * 
 * @property side                Order side.
 * @property price               Price.
 * @property origQty             Original quantity.
 * @property executedQty         Original quantity.
 * @property cummulativeQuoteQty Used to calculate the average price.
 * @property status              Order status.
 * @property timeInForce         Time in force to indicate how long will the order
 *                            remain active.
 * @property type                Type of order.
 * @property stopPrice           Used with stop orders.
 * @property icebergQty          Used with iceberg orders.
 * @property time                Order timestamp.
 * @property updateTime          Update timestamp.
 * @property origQuoteOrderQty   Original quote order quantity.
 * @property isWorking           is working.
 * @property isIsolated          is isolated margin.
 * @property symbol              Order symbol.
 * @property orderId             Order id.
 * @property clientOrderId       Client order id.
 * @property accountId           Account id.
 */
@ApiModel("Trade order information.")
data class OrderInfo(
@ApiModelProperty("The order side.")
@JsonProperty("side") var side:String?=null,
@ApiModelProperty("Price.")
@JsonProperty("price") var price:String?=null,
@ApiModelProperty("Original quantity.")
@JsonProperty("origQty") var origQty:String?=null,
@ApiModelProperty("Original quantity.")
@JsonProperty("executedQty") var executedQty:String?=null,
@ApiModelProperty("Used to calculate the average price.")
@JsonProperty("cummulativeQuoteQty") var cummulativeQuoteQty:String?=null,
@ApiModelProperty("Order status.")
@JsonProperty("status") var status:String?=null,
@ApiModelProperty("Time in force to indicate how long will the order remain active.")
@JsonProperty("timeInForce") var timeInForce:String?=null,
@ApiModelProperty("Type of order.")
@JsonProperty("type") var type:String?=null,
@ApiModelProperty("Used with stop orders.")
@JsonProperty("stopPrice") var stopPrice:String?=null,
@ApiModelProperty("Used with iceberg orders.")
@JsonProperty("icebergQty") var icebergQty:String?=null,
@ApiModelProperty("Order timestamp.")
@JsonProperty("time") var time:Long?=null,
@ApiModelProperty("Update timestamp.")
@JsonProperty("updateTime") var updateTime:Long?=null,
@ApiModelProperty("Original quote order quantity.")
@JsonProperty("origQuoteOrderQty") var origQuoteOrderQty:String?=null,
@ApiModelProperty("is working.")
@JsonProperty("isWorking") var isWorking:Boolean?=null,
@ApiModelProperty("is isolated margin.")
@JsonProperty("isIsolated") var isIsolated:Boolean?=null,
@ApiModelProperty("The order symbol.")
@JsonProperty("symbol") var symbol:String?=null,
@ApiModelProperty("Order id.")
@JsonProperty("orderId") var orderId:Long?=null,
@ApiModelProperty("Client order id.")
@JsonProperty("clientOrderId") var clientOrderId:String?=null,
@ApiModelProperty("Account id.")
@JsonProperty("accountId") var accountId:String?=null)
{
}