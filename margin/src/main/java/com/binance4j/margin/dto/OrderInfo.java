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
var side:String?=null,
@ApiModelProperty("Price.")
var price:String?=null,
@ApiModelProperty("Original quantity.")
var origQty:String?=null,
@ApiModelProperty("Original quantity.")
var executedQty:String?=null,
@ApiModelProperty("Used to calculate the average price.")
var cummulativeQuoteQty:String?=null,
@ApiModelProperty("Order status.")
var status:String?=null,
@ApiModelProperty("Time in force to indicate how long will the order remain active.")
var timeInForce:String?=null,
@ApiModelProperty("Type of order.")
var type:String?=null,
@ApiModelProperty("Used with stop orders.")
var stopPrice:String?=null,
@ApiModelProperty("Used with iceberg orders.")
var icebergQty:String?=null,
@ApiModelProperty("Order timestamp.")
var time:Long?=null,
@ApiModelProperty("Update timestamp.")
var updateTime:Long?=null,
@ApiModelProperty("Original quote order quantity.")
var origQuoteOrderQty:String?=null,
@ApiModelProperty("is working.")
var isWorking:Boolean?=null,
@ApiModelProperty("is isolated margin.")
var isIsolated:Boolean?=null,
@ApiModelProperty("The order symbol.")
var symbol:String?=null,
@ApiModelProperty("Order id.")
var orderId:Long?=null,
@ApiModelProperty("Client order id.")
var clientOrderId:String?=null,
@ApiModelProperty("Account id.")
var accountId:String?=null)
{
}