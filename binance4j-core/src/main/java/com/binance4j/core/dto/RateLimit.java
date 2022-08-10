package com.binance4j.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Requests and orders rate limit.
 * 
 * @param rateLimitType Rate limit type.
 * @param interval      Limit interval type.
 * @param intervalNum   Limit interval number.
 * @param limit         Limit for the given interval.
 */
@ApiModel("Requests and orders rate limit.")
public record RateLimit(@ApiModelProperty("The rate limit type.") String rateLimitType,
		@ApiModelProperty("The limit interval type.") String interval,
		@ApiModelProperty("The limit interval number.") int intervalNum,
		@ApiModelProperty("The limit for the given interval.") int limit) {
}