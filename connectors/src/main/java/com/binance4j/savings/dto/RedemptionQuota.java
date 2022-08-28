package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Flexible redemption quota.
 * 
 * @property asset               Asset.
 * @property dailyQuota          Daily quota.
 * @property leftQuota           Left quota.
 * @property minRedemptionAmount Min redemption amount.
 */
@ApiModel("Flexible redemption quota.")
data class RedemptionQuota(
@ApiModelProperty("Asset.")
@JsonProperty("asset") var asset:String?=null,
@ApiModelProperty("Daily quota.")
@JsonProperty("dailyQuota") var dailyQuota:String?=null,
@ApiModelProperty("Left quota.")
@JsonProperty("leftQuota") var leftQuota:String?=null,
@ApiModelProperty("Min redemption amount.")
@JsonProperty("minRedemptionAmount") var minRedemptionAmount:String?=null)
{
}