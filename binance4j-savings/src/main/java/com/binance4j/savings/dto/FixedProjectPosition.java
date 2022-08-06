package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A fixed project position.
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
@ApiModel("A fixed project position.")
public record FixedProjectPosition(@ApiModelProperty("Asset.") String asset, @ApiModelProperty("Can transfer.") boolean canTransfer,
		@ApiModelProperty("Create timestamp.") long createTimestamp, @ApiModelProperty("Duration.") long duration, @ApiModelProperty("Endtime.") long endTime,
		@ApiModelProperty("Interest.") String interest, @ApiModelProperty("Interest rate.") String interestRate, @ApiModelProperty("Lot.") long lot,
		@ApiModelProperty("Position id.") long positionId, @ApiModelProperty("Principal.") String principal, @ApiModelProperty("Project id.") String projectId,
		@ApiModelProperty("Project name.") String projectName, @ApiModelProperty("Purchase time.") long purchaseTime,
		@ApiModelProperty("Redeem date.") String redeemDate, @ApiModelProperty("Start time.") long startTime, @ApiModelProperty("Status.") String status,
		@ApiModelProperty("Type.") String type) {
}
