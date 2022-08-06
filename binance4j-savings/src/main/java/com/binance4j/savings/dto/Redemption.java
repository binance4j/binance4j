package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Redemption infos.
 * 
 * @param amount      Amount.
 * @param asset       Asset.
 * @param createTime  Create time.
 * @param principal   Principal.
 * @param projectId   Project id.
 * @param projectName Project name.
 * @param status      Status.
 * @param type        Type.
 */
@ApiModel("")
public record Redemption(@ApiModelProperty("") String amount, @ApiModelProperty("") String asset, @ApiModelProperty("") long createTime,
		@ApiModelProperty("") String principal, @ApiModelProperty("") String projectId, @ApiModelProperty("") String projectName,
		@ApiModelProperty("") String status, @ApiModelProperty("") String type) {
}