package com.binance4j.spot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * OCO order report.
 * 
 * @property symbol              Symbol.
 * @property orderId             Order Id.
 * @property orderListId         Order List Id.
 * @property clientOrderId       Client Order Id.
 * @property transactTime        Transact Time.
 * @property price               Price.
 * @property origQty             Original Quantity.
 * @property executedQty         Executed Quantity.
 * @property cummulativeQuoteQty Cummulative Quote Quantity.
 * @property status              Status.
 * @property timeInForce         Time In Force.
 * @property type                Type.
 * @property side                Side.
 * @property stopPrice           StopPrice.
 */
@ApiModel("OCO order report.")
data class OCOOrderReport(
@ApiModelProperty("Symbol.")
var symbol:String?=null,
@ApiModelProperty("Order Id.")
var orderId:Long?=null,
@ApiModelProperty("Order List Id.")
var orderListId:Long?=null,
@ApiModelProperty("Client Order Id.")
var clientOrderId:String?=null,
@ApiModelProperty("Transact Time.")
var transactTime:Long?=null,
@ApiModelProperty("Price.")
var price:String?=null,
@ApiModelProperty("Original Quantity.")
var origQty:String?=null,
@ApiModelProperty("Executed Quantity.")
var executedQty:String?=null,
@ApiModelProperty("Cummulative Quote Quantity.")
var cummulativeQuoteQty:String?=null,
@ApiModelProperty("Status.")
var status:String?=null,
@ApiModelProperty("Time In Force.")
var timeInForce:String?=null,
@ApiModelProperty("Type.")
var type:String?=null,
@ApiModelProperty("Side.")
var side:String?=null,
@ApiModelProperty("StopPrice.")
var stopPrice:String?=null)
{
}
