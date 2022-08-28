package com.binance4j.margin.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Isolated margin fee.
 * 
 * @property vipLevel VIP level.
 * @property symbol   Related symbol.
 * @property leverage Leverage.
 * @property data     Isolated fee data.
 */
@ApiModel("Isolated margin fee.")
data class IsolatedFee(
@ApiModelProperty("VIP level.")
var vipLevel:int?=null,
@ApiModelProperty("Related symbol.")
var symbol:String?=null,
@ApiModelProperty("Leverage.")
var leverage:String?=null,
@ApiModelProperty("Isolated fee data.") List<IsolatedFeeData> data)
{
}