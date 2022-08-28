package com.binance4j.spot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * OCO order infos.
 * 
 * @property symbol        symbol.
 * @property orderId       order id.
 * @property clientOrderId client order id.
 */
@ApiModel("OCO order infos.")
data class OCOOrder(
@ApiModelProperty("symbol.")
@JsonProperty("symbol") var symbol:String?=null,
@ApiModelProperty("order id.")
@JsonProperty("orderId") var orderId:Long?=null,
@ApiModelProperty("client order id.")
@JsonProperty("clientOrderId") var clientOrderId:String?=null)
{
}
