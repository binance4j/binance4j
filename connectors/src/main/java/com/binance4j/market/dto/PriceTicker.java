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
 val symbol : String,
@ApiModelProperty("Latest price.")
 val price : String)
{
}
