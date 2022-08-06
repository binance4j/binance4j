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
@ApiModel("A staking product.")
public record Product(@ApiModelProperty("Project id.") String projectId, @ApiModelProperty("Detail.") ProductDetail detail,
		@ApiModelProperty("Quota.") ProductQuota quota) {
}