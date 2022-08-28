package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Max transferable amount.
 * 
 * @property amount Max transferable amount.
 */
@ApiModel("Max transferable amount.")
data class MaxTransferable(
@ApiModelProperty("Max transferable amount.")
var amount:String?=null)
{
}