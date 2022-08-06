package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Staking record.
 * 
 * @param positionId  Position id.
 * @param time        Time.
 * @param asset       Asset.
 * @param project     Project.
 * @param amount      Amount.
 * @param lockPeriod  Lock period.
 * @param deliverDate Deliver date.
 * @param type        Type.
 * @param status      Status.
 */
@ApiModel("Staking record.")
public record StakingRecord(@ApiModelProperty("Position id.") String positionId, @ApiModelProperty("Time.") String time,
		@ApiModelProperty("Asset.") String asset, @ApiModelProperty("Project.") String project, @ApiModelProperty("Amount.") String amount,
		@ApiModelProperty("Lock period.") String lockPeriod, @ApiModelProperty("Deliver date.") String deliverDate, @ApiModelProperty("Type.") String type,
		@ApiModelProperty("Status.") String status) {
}
