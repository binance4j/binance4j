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
@JsonProperty("symbol") var symbol:String?=null,
@ApiModelProperty("Order Id.")
@JsonProperty("orderId") var orderId:Long?=null,
@ApiModelProperty("Order List Id.")
@JsonProperty("orderListId") var orderListId:Long?=null,
@ApiModelProperty("Client Order Id.")
@JsonProperty("clientOrderId") var clientOrderId:String?=null,
@ApiModelProperty("Transact Time.")
@JsonProperty("transactTime") var transactTime:Long?=null,
@ApiModelProperty("Price.")
@JsonProperty("price") var price:String?=null,
@ApiModelProperty("Original Quantity.")
@JsonProperty("origQty") var origQty:String?=null,
@ApiModelProperty("Executed Quantity.")
@JsonProperty("executedQty") var executedQty:String?=null,
@ApiModelProperty("Cummulative Quote Quantity.")
@JsonProperty("cummulativeQuoteQty") var cummulativeQuoteQty:String?=null,
@ApiModelProperty("Status.")
@JsonProperty("status") var status:String?=null,
@ApiModelProperty("Time In Force.")
@JsonProperty("timeInForce") var timeInForce:String?=null,
@ApiModelProperty("Type.")
@JsonProperty("type") var type:String?=null,
@ApiModelProperty("Side.")
@JsonProperty("side") var side:String?=null,
@ApiModelProperty("StopPrice.")
@JsonProperty("stopPrice") var stopPrice:String?=null)
{
}
