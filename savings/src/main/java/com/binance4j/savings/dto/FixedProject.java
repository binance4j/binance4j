package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Fixed or activity project.
 * 
 * @param asset              Asset.
 * @param displayPriority    Display priority.
 * @param duration           Duration.
 * @param interestPerLot     Interest per lot.
 * @param interestRate       Interest rate.
 * @param lotSize            Lot size.
 * @param lotsLowLimit       Lots low limit.
 * @param lotsPurchased      Lots purchased.
 * @param lotsUpLimit        Lots up limit.
 * @param maxLotsPerUser     Max lots per user.
 * @param needKyc            Need kyc.
 * @param projectId          Project id.
 * @param projectName        Project name.
 * @param status             Status.
 * @param type               Type.
 * @param withAreaLimitation With area limitation.
 */
@ApiModel("Fixed or activity project.")
public record FixedProject(@ApiModelProperty("Asset.") String asset,
		@ApiModelProperty("Display priority.") long displayPriority,
		@ApiModelProperty("Duration.") long duration, @ApiModelProperty("Interest per lot.") String interestPerLot,
		@ApiModelProperty("Interest rate.") String interestRate, @ApiModelProperty("Lot size.") String lotSize,
		@ApiModelProperty("Lots low limit.") long lotsLowLimit, @ApiModelProperty("Lots purchased.") long lotsPurchased,
		@ApiModelProperty("Lots up limit.") long lotsUpLimit,
		@ApiModelProperty("Max lots per user.") long maxLotsPerUser,
		@ApiModelProperty("Need kyc.") boolean needKyc, @ApiModelProperty("Project id.") String projectId,
		@ApiModelProperty("Project name.") String projectName, @ApiModelProperty("Status.") String status,
		@ApiModelProperty("Type.") String type,
		@ApiModelProperty("With area limitation.") boolean withAreaLimitation) {
}