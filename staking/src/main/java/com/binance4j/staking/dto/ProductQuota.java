package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Staking product quota.
 * 
 * @param totalPersonalQuota Total personal quota.
 * @param minimum            Minimum.
 * @param quotaPerOrder      Quota per order.
 */
@ApiModel("Staking product quota.")
public record ProductQuota(@ApiModelProperty("Total personal quota.") String totalPersonalQuota,
		@ApiModelProperty("Minimum.") String minimum,
		@ApiModelProperty("Quota per order.") String quotaPerOrder) {
}