package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Staking record.
 * 
 * @param positionId  position id.
 * @param time        time.
 * @param asset       asset.
 * @param project     project.
 * @param amount      amount.
 * @param lockPeriod  lock period.
 * @param deliverDate deliver date.
 * @param type        type.
 * @param status      status.
 */
@ApiModel("")
public record StakingRecord(@ApiModelProperty("") String positionId, @ApiModelProperty("") String time, @ApiModelProperty("") String asset,
		@ApiModelProperty("") String project, @ApiModelProperty("") String amount, @ApiModelProperty("") String lockPeriod,
		@ApiModelProperty("") String deliverDate, @ApiModelProperty("") String type, @ApiModelProperty("") String status) {
}
