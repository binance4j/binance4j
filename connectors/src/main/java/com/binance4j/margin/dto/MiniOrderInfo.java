package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Trade order information.
 * 
 * @property symbol        Order symbol.
 * @property orderId       Order id.
 * @property clientOrderId Client order id.
 */
@ApiModel("Trade order information.")
data class MiniOrderInfo(
@ApiModelProperty("Order symbol.")
@JsonProperty("symbol") var symbol:String?=null,
@ApiModelProperty("Order id.")
@JsonProperty("orderId") var orderId:Long?=null,
@ApiModelProperty("Client order id.")
@JsonProperty("clientOrderId") var clientOrderId:String?=null)
{
}