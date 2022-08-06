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
@ApiModel("")
public record FixedProject(@ApiModelProperty("") String asset, @ApiModelProperty("") long displayPriority, @ApiModelProperty("") long duration,
		@ApiModelProperty("") String interestPerLot, @ApiModelProperty("") String interestRate, @ApiModelProperty("") String lotSize,
		@ApiModelProperty("") long lotsLowLimit, @ApiModelProperty("") long lotsPurchased, @ApiModelProperty("") long lotsUpLimit,
		@ApiModelProperty("") long maxLotsPerUser, @ApiModelProperty("") boolean needKyc, @ApiModelProperty("") String projectId,
		@ApiModelProperty("") String projectName, @ApiModelProperty("") String status, @ApiModelProperty("") String type,
		@ApiModelProperty("") boolean withAreaLimitation) {
}