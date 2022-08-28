package com.binance4j.rebate.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A rebate.
 * 
 * @property asset      Rebate asset.
 * @property type       Rebate type.
 * @property amount     Rebate amount.
 * @property updateTime Rebate update time.
 * @see RebateType
 */
@ApiModel("A rebate.")
data class Rebate(
@ApiModelProperty("Rebate asset.")
var asset:String?=null,
@ApiModelProperty("Rebate type.")
var type:String?=null,
@ApiModelProperty("Rebate amount.")
var amount:String?=null,
@ApiModelProperty("Rebate update time.") var updateTime:Long?=null)
{
}
