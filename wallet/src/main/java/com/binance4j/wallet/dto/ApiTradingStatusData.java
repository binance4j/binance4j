package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The API trading status detail.
 * 
 * @param isLocked           API trading function is locked or not.
 * @param plannedRecoverTime If API trading function is locked, this is the
 *                           planned recover time.
 * @param updateTime         Details update timestamps.
 * @param triggerCondition   Trigger condition.
 */
@ApiModel("The API trading status detail.")
public record ApiTradingStatusData(@ApiModelProperty("API trading function is locked or not.") boolean isLocked,
		@ApiModelProperty("If API trading function is locked, this is the planned recover time.") long plannedRecoverTime,
		@ApiModelProperty("Details update timestamps.") long updateTime,
		@ApiModelProperty("Trigger condition.") ApiTradingStatusTriggerCondition triggerCondition) {
}