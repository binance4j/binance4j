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
 val symbol : String,
@ApiModelProperty("order id.")
 val orderId : Long,
@ApiModelProperty("client order id.")
 val clientOrderId : String)
{
}
