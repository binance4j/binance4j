package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Margin Order rate limit.
 * 
 * @property rateLimitType Rate limit type.
 * @property interval      Interval.
 * @property intervalNum   Interval num.
 * @property limit         Limit.
 * @property count         Count.
 */
@ApiModel("Margin Order rate limit.")
data class OrderRateLimit(
@ApiModelProperty("Rate limit type.")
@JsonProperty("rateLimitType") var rateLimitType: String = "",
@ApiModelProperty("Interval.")
@JsonProperty("interval") var interval: String = "",
@ApiModelProperty("Interval num.")
@JsonProperty("intervalNum") var intervalNum:Int = 0,
@ApiModelProperty("Limit.")
@JsonProperty("limit") var limit:Int = 0,
@ApiModelProperty("Count.") @JsonProperty("count") var count:Int = 0)
{

}
