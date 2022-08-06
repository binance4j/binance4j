package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A fixed project.
 * 
 * @param asset           Asset.
 * @param canTransfer     Can transfer.
 * @param createTimestamp Create timestamp.
 * @param duration        Duration.
 * @param endTime         Endtime.
 * @param interest        Interest.
 * @param interestRate    Interest rate.
 * @param lot             Lot.
 * @param positionId      Position id.
 * @param principal       Principal.
 * @param projectId       Project id.
 * @param projectName     Project name.
 * @param purchaseTime    Purchase time.
 * @param redeemDate      Redeem date.
 * @param startTime       Start time.
 * @param status          Status.
 * @param type            Type.
 */
@ApiModel("")
public record FixedProjectPosition(@ApiModelProperty("") String asset, @ApiModelProperty("") boolean canTransfer, @ApiModelProperty("") long createTimestamp,
		@ApiModelProperty("") long duration, @ApiModelProperty("") long endTime, @ApiModelProperty("") String interest,
		@ApiModelProperty("") String interestRate, @ApiModelProperty("") long lot, @ApiModelProperty("") long positionId,
		@ApiModelProperty("") String principal, @ApiModelProperty("") String projectId, @ApiModelProperty("") String projectName,
		@ApiModelProperty("") long purchaseTime, @ApiModelProperty("") String redeemDate, @ApiModelProperty("") long startTime,
		@ApiModelProperty("") String status, @ApiModelProperty("") String type) {
}
