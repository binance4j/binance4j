package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Current average price for a symbol.
 * 
 * @property mins  Mins.
 * @property price Average price of the asset.
 */
@ApiModel("Current average price for a symbol.")
data class AveragePrice(
@ApiModelProperty("Mins.")
@JsonProperty("mins") var mins:Int = 0,
@ApiModelProperty("Average price of the asset.")
@JsonProperty("price") var price: String = "")
{
}
