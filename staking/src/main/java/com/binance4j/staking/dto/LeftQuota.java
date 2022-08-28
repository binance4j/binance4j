package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Personal left quota.
 * 
 * @param leftPersonalQuota User left quota.
 */
@ApiModel("Personal left quota.")
public record LeftQuota(@ApiModelProperty("User left quota.") String leftPersonalQuota) {
}