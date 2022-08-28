package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Lending interest.
 * 
 * @property asset       Asset.
 * @property interest    Interest.
 * @property lendingType LendingType.
 * @property productName ProductName.
 * @property time        Time in ms.
 */
@ApiModel("Lending interest.")
data class Interest(
@ApiModelProperty("Asset.")
var asset:String?=null,
@ApiModelProperty("Interest.")
var interest:String?=null,
@ApiModelProperty("LendingType.")
var lendingType:String?=null,
@ApiModelProperty("ProductName.")
var productName:String?=null,
@ApiModelProperty("Time in ms.") var time:Long?=null)
{
}