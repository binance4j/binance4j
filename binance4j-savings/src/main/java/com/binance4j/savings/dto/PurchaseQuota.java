package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Flexible purchase quota.
 * 
 * @param asset     Asset.
 * @param leftQuota Left quota.
 */
@ApiModel("Flexible purchase quota.")
public record PurchaseQuota(@ApiModelProperty("Asset.") String asset, @ApiModelProperty("Left quota.") String leftQuota) {
}