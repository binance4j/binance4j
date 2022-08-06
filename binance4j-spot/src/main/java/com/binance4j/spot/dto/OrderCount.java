package com.binance4j.spot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The user's current order count usage for all intervals.
 * 
 * @param rateLimitType Type of order.
 * @param interval      Order interval.
 * @param intervalNum   Order interval num.
 * @param limit         Order limit.
 * @param count         Current order count.
 */
@ApiModel("The user's current order count usage for all intervals.")
public record OrderCount(@ApiModelProperty("Type of order.") String rateLimitType, @ApiModelProperty("Order interval.") String interval,
		@ApiModelProperty("Order interval num.") int intervalNum, @ApiModelProperty("Order limit.") int limit,
		@ApiModelProperty("Current order count.") int count) {
}