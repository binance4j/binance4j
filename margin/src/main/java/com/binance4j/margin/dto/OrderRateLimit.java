package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Margin Order rate limit.
 * 
 * @param rateLimitType Rate limit type.
 * @param interval      Interval.
 * @param intervalNum   Interval num.
 * @param limit         Limit.
 * @param count         Count.
 */
@ApiModel("Margin Order rate limit.")
public record OrderRateLimit(@ApiModelProperty("Rate limit type.") String rateLimitType,
		@ApiModelProperty("Interval.") String interval,
		@ApiModelProperty("Interval num.") int intervalNum, @ApiModelProperty("Limit.") int limit,
		@ApiModelProperty("Count.") int count) {

}
