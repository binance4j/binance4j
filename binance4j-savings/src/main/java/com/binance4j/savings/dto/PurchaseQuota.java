package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Flexible purchase quota.
 * 
 * @param asset     Asset.
 * @param leftQuota Left quota.
 */
@ApiModel("")
public record PurchaseQuota(@ApiModelProperty("") String asset, @ApiModelProperty("") String leftQuota) {
}