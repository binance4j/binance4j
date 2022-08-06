package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A staking product.
 * 
 * @param projectId Project id.
 * @param detail    Detail.
 * @param quota     Quota.
 */
@ApiModel("")
public record Product(@ApiModelProperty("") String projectId, @ApiModelProperty("") ProductDetail detail, @ApiModelProperty("") ProductQuota quota) {
}