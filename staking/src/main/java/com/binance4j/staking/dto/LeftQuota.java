package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Personal left quota.
 * 
 * @property leftPersonalQuota User left quota.
 */
@ApiModel("Personal left quota.")
data class LeftQuota(
@ApiModelProperty("User left quota.")
var leftPersonalQuota:String?=null)
{
}