package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Defines the minimum and maximum value for the parameter trailingDelta.
 * 
 * @param minTrailingAboveDelta The min trailing above delta.
 * @param maxTrailingAboveDelta The max trailing above delta.
 * @param minTrailingBelowDelta The min trailing below delta.
 * @param maxTrailingBelowDelta The max trailing below delta.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@ApiModel("")
public record TrailingDeltaFilter(@ApiModelProperty("") String minTrailingAboveDelta, @ApiModelProperty("") String maxTrailingAboveDelta,
		@ApiModelProperty("") String minTrailingBelowDelta, @ApiModelProperty("") String maxTrailingBelowDelta) {
}