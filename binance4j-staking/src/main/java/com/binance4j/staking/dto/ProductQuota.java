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
@ApiModel("")
public record ProductQuota(@ApiModelProperty("") String totalPersonalQuota, @ApiModelProperty("") String minimum, @ApiModelProperty("") String quotaPerOrder) {
}