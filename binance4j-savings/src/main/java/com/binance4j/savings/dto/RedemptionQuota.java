package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Flexible redemption quota.
 * 
 * @param asset               Asset.
 * @param dailyQuota          Daily quota.
 * @param leftQuota           Left quota.
 * @param minRedemptionAmount Min redemption amount.
 */
@ApiModel("")
public record RedemptionQuota(@ApiModelProperty("") String asset, @ApiModelProperty("") String dailyQuota, @ApiModelProperty("") String leftQuota,
		@ApiModelProperty("") String minRedemptionAmount) {
}