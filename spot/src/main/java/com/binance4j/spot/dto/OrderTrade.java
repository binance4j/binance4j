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
var price:String?=null,
@ApiModelProperty("Quantity.")
var qty:String?=null,
@ApiModelProperty("Commission.")
var commission:String?=null,
@ApiModelProperty("Commission asset.")
var commissionAsset:String?=null,
@ApiModelProperty("Trade id.") var tradeId:Long?=null)
{
}
