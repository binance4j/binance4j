package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The CancelOrder request result.
 * 
 * @property status              Status.
 * @property side                Side.
 * @property type                Type.
 * @property timeInForce         Time in force.
 * @property orderId             Order id.
 * @property orderListId         Order list id.
 * @property symbol              Symbol.
 * @property origClientOrderId   Orig client order id.
 * @property clientOrderId       Client order id.
 * @property executedQty         Executed quantity.
 * @property price               Price.
 * @property origQty             Original quantity.
 * @property cummulativeQuoteQty Cummulative quote quantity.
 * @property isIsolated          Is isolated.
 */
@ApiModel("The CancelOrder request result.")
data class CancelOrderResponse(
@ApiModelProperty("Status.")
var status:String?=null,
@ApiModelProperty("Side.")
var side:String?=null,
@ApiModelProperty("Type.")
var type:String?=null,
@ApiModelProperty("Time in force.")
var timeInForce:String?=null,
@ApiModelProperty("Order id.")
var orderId:Long?=null,
@ApiModelProperty("Order list id.")
var orderListId:Long?=null,
@ApiModelProperty("Symbol.")
var symbol:String?=null,
@ApiModelProperty("Orig client order id.")
var origClientOrderId:String?=null,
@ApiModelProperty("Client order id.")
var clientOrderId:String?=null,
@ApiModelProperty("Executed quantity.")
var executedQty:String?=null,
@ApiModelProperty("Price.")
var price:String?=null,
@ApiModelProperty("Original quantity.")
var origQty:String?=null,
@ApiModelProperty("Cummulative quote quantity.")
var cummulativeQuoteQty:String?=null,
@ApiModelProperty("Is isolated.") var isIsolated:Boolean?=null)
{
}