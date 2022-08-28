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
@JsonProperty("price") var price:String?=null,
@ApiModelProperty("Quantity.")
@JsonProperty("qty") var qty:String?=null,
@ApiModelProperty("Commission.")
@JsonProperty("commission") var commission:String?=null,
@ApiModelProperty("Commission asset.")
@JsonProperty("commissionAsset") var commissionAsset:String?=null,
@ApiModelProperty("Trade id.") @JsonProperty("tradeId") var tradeId:Long?=null)
{
}
