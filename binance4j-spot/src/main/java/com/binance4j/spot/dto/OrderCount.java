package com.binance4j.spot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The user's current order count usage for all intervals.
 * 
 * @param rateLimitType The type of order.
 * @param interval      The order interval.
 * @param intervalNum   The order interval num.
 * @param limit         The order limit.
 * @param count         The current order count.
 */
@ApiModel("")
public record OrderCount(@ApiModelProperty("") String rateLimitType, @ApiModelProperty("") String interval, @ApiModelProperty("") int intervalNum,
		@ApiModelProperty("") int limit, @ApiModelProperty("") int count) {
}