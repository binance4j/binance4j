package com.binance4j.pay.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Funds detail.
 * 
 * @property currency Asset.
 * @property amount   Amount.
 */
@ApiModel("Funds detail.")
data class FundsDetail(
@ApiModelProperty("Asset.")
var currency:String?=null,
@ApiModelProperty("Amount.")
var amount:String?=null)
{
}
