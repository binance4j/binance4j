package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The API trading status detail.
 * 
 * @param isLocked           API trading function is locked or not.
 * @param plannedRecoverTime If API trading function is locked,@ApiModelProperty("") this is the planned recover time.
 * @param updateTime         The details update timestamps.
 * @param triggerCondition   Trigger condition.
 */
@ApiModel("")
public record ApiTradingStatusData(@ApiModelProperty("") boolean isLocked, @ApiModelProperty("") long plannedRecoverTime, @ApiModelProperty("") long updateTime,
		@ApiModelProperty("") ApiTradingStatusTriggerCondition triggerCondition) {
}