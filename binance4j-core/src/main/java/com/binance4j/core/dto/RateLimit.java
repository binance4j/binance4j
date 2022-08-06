package com.binance4j.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Requests and orders rate limit.
 * 
 * @param rateLimitType The rate limit type.
 * @param interval      The limit interval type.
 * @param intervalNum   The limit interval number.
 * @param limit         The limit for the given interval.
 */
@ApiModel("Requests and orders rate limit.")
public record RateLimit(@ApiModelProperty("The rate limit type.") String rateLimitType, @ApiModelProperty("The limit interval type.") String interval,
		@ApiModelProperty("The limit interval number.") int intervalNum, @ApiModelProperty("The limit for the given interval.") int limit) {
}