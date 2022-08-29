package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The maximum allowed position an account can have on the base asset of a
 * symbol.
 * 
 * @property maxPosition Max positions allowed.
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@ApiModel("he maximum allowed position an account can have on the base asset of a symbol.")
data class MaxPositionFilter(
@ApiModelProperty("Max positions allowed.")
 val maxPosition : String)
{
}