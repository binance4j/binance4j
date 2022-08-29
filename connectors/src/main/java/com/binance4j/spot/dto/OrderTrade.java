package com.binance4j.spot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The partial trade of an order.
 * 
 * @property price           Price.
 * @property qty             Quantity.
 * @property commission      Commission.
 * @property commissionAsset Commission asset.
 * @property tradeId         Trade id.
 */
@ApiModel("The partial trade of an order.")
data class OrderTrade(
@ApiModelProperty("Price.")
 val price : String,
@ApiModelProperty("Quantity.")
 val qty : String,
@ApiModelProperty("Commission.")
 val commission : String,
@ApiModelProperty("Commission asset.")
 val commissionAsset : String,
@ApiModelProperty("Trade id.")  val tradeId : Long)
{
}
