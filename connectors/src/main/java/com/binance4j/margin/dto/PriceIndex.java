package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A symbol price index.
 * 
 * @property calcTime Last price calculation timestamp in ms.
 * @property price    Price.
 * @property symbol   Asset pair.
 */
@ApiModel("A symbol price index.")
data class PriceIndex(
@ApiModelProperty("Last price calculation timestamp in ms.")
@JsonProperty("calcTime") var calcTime: Long = 0L,
@ApiModelProperty("Price.")
@JsonProperty("price") var price: String = "",
@ApiModelProperty("Asset pair.")
@JsonProperty("symbol") var symbol: String = "")
{
}
