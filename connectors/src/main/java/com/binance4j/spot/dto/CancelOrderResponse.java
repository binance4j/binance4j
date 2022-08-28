package com.binance4j.spot.dto;

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
 */
@ApiModel("The CancelOrder request result.")
data class CancelOrderResponse(
@ApiModelProperty("Status.")
@JsonProperty("status") var status:String?=null,
@ApiModelProperty("Side.")
@JsonProperty("side") var side:String?=null,
@ApiModelProperty("Type.")
@JsonProperty("type") var type:String?=null,
@ApiModelProperty("Time in force.")
@JsonProperty("timeInForce") var timeInForce:String?=null,
@ApiModelProperty("Order id.")
@JsonProperty("orderId") var orderId:Long?=null,
@ApiModelProperty("Order list id.")
@JsonProperty("orderListId") var orderListId:Long?=null,
@ApiModelProperty("Symbol.")
@JsonProperty("symbol") var symbol:String?=null,
@ApiModelProperty("Orig client order id.")
@JsonProperty("origClientOrderId") var origClientOrderId:String?=null,
@ApiModelProperty("Client order id.")
@JsonProperty("clientOrderId") var clientOrderId:String?=null,
@ApiModelProperty("Executed quantity.")
@JsonProperty("executedQty") var executedQty:String?=null,
@ApiModelProperty("Price.")
@JsonProperty("price") var price:String?=null,
@ApiModelProperty("Original quantity.")
@JsonProperty("origQty") var origQty:String?=null,
@ApiModelProperty("Cummulative quote quantity.")
@JsonProperty("cummulativeQuoteQty") var cummulativeQuoteQty:String?=null)
{
}