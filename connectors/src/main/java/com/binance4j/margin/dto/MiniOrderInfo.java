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
 val symbol : String,
@ApiModelProperty("Order id.")
 val orderId : Long,
@ApiModelProperty("Client order id.")
 val clientOrderId : String)
{
}