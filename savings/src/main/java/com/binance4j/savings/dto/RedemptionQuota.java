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
@ApiModel("Flexible redemption quota.")
public record RedemptionQuota(@ApiModelProperty("Asset.") String asset, @ApiModelProperty("Daily quota.") String dailyQuota,
		@ApiModelProperty("Left quota.") String leftQuota, @ApiModelProperty("Min redemption amount.") String minRedemptionAmount) {
}