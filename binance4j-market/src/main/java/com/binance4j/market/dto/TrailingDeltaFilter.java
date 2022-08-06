package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The minimum and maximum value for the parameter trailingDelta.
 * 
 * @param minTrailingAboveDelta Min trailing above delta.
 * @param maxTrailingAboveDelta Max trailing above delta.
 * @param minTrailingBelowDelta Min trailing below delta.
 * @param maxTrailingBelowDelta Max trailing below delta.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@ApiModel("The minimum and maximum value for the parameter trailingDelta.")
public record TrailingDeltaFilter(@ApiModelProperty("Min trailing above delta.") String minTrailingAboveDelta,
		@ApiModelProperty("Max trailing above delta.") String maxTrailingAboveDelta,
		@ApiModelProperty("Min trailing below delta.") String minTrailingBelowDelta,
		@ApiModelProperty("Max trailing below delta.") String maxTrailingBelowDelta) {
}