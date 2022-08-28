package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Position Amount.
 * 
 * @property amount       Amount.
 * @property amountInBTC  Amount in BTC.
 * @property amountInUSDT Amount in USDT.
 * @property asset        Asset.
 */
@ApiModel("Position Amount.")
data class PositionAmount(
@ApiModelProperty("Amount.")
var amount:String?=null,
@ApiModelProperty("Amount in BTC.")
var amountInBTC:String?=null,
@ApiModelProperty("Amount in USDT.")
var amountInUSDT:String?=null,
@ApiModelProperty("Asset.")
var asset:String?=null)
{
}
