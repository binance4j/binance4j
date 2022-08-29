package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The minimum and maximum value for the parameter trailingDelta.
 * 
 * @property minTrailingAboveDelta Min trailing above delta.
 * @property maxTrailingAboveDelta Max trailing above delta.
 * @property minTrailingBelowDelta Min trailing below delta.
 * @property maxTrailingBelowDelta Max trailing below delta.
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@ApiModel("The minimum and maximum value for the parameter trailingDelta.")
data class TrailingDeltaFilter(
@ApiModelProperty("Min trailing above delta.")
@JsonProperty("minTrailingAboveDelta") var minTrailingAboveDelta: String = "",
@ApiModelProperty("Max trailing above delta.")
@JsonProperty("maxTrailingAboveDelta") var maxTrailingAboveDelta: String = "",
@ApiModelProperty("Min trailing below delta.")
@JsonProperty("minTrailingBelowDelta") var minTrailingBelowDelta: String = "",
@ApiModelProperty("Max trailing below delta.")
@JsonProperty("maxTrailingBelowDelta") var maxTrailingBelowDelta: String = "")
{
}