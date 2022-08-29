package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Wraps a symbol and its corresponding latest price.
 * 
 * @property symbol Ticker symbol.
 * @property price  Latest price.
 */
@ApiModel("Wraps a symbol and its corresponding latest price.")
data class PriceTicker(
@ApiModelProperty("Ticker symbol.")
@JsonProperty("symbol") var symbol: String = "",
@ApiModelProperty("Latest price.")
@JsonProperty("price") var price: String = "")
{
}
