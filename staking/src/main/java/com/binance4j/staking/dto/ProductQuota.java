package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Staking product quota.
 * 
 * @property totalPersonalQuota Total personal quota.
 * @property minimum            Minimum.
 * @property quotaPerOrder      Quota per order.
 */
@ApiModel("Staking product quota.")
data class ProductQuota(
@ApiModelProperty("Total personal quota.")
@JsonProperty("totalPersonalQuota") var totalPersonalQuota:String?=null,
@ApiModelProperty("Minimum.")
@JsonProperty("minimum") var minimum:String?=null,
@ApiModelProperty("Quota per order.")
@JsonProperty("quotaPerOrder") var quotaPerOrder:String?=null)
{
}