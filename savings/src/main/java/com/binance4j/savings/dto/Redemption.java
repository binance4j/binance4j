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
@ApiModel("Redemption infos.")
public record Redemption(@ApiModelProperty("Amount.") String amount, @ApiModelProperty("Asset.") String asset,
		@ApiModelProperty("Create time.") long createTime, @ApiModelProperty("Principal.") String principal, @ApiModelProperty("Project id.") String projectId,
		@ApiModelProperty("Project name.") String projectName, @ApiModelProperty("Status.") String status, @ApiModelProperty("Type.") String type) {
}