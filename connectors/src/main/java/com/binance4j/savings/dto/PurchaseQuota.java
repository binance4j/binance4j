package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Flexible purchase quota.
 * 
 * @property asset     Asset.
 * @property leftQuota Left quota.
 */
@ApiModel("Flexible purchase quota.")
data class PurchaseQuota(
@ApiModelProperty("Asset.")
@JsonProperty("asset") var asset:String?=null,
@ApiModelProperty("Left quota.")
@JsonProperty("leftQuota") var leftQuota:String?=null)
{
}