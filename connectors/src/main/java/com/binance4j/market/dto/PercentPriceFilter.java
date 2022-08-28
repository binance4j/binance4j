package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Defines valid range for a price based on the average of the previous trades.
 * avgPriceMins is the number of minutes
 * the average price is calculated over. 0 means the last price is used.
 * 
 * @property multiplierUp   Multiplier up.
 * @property multiplierDown Multiplier down.
 * @property avgPriceMins   Weighted average price.
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 *      *
 */
@ApiModel("Defines valid range for a price based on the average of the previous trades. avgPriceMins is the number of minutes the average price is calculated over. 0 means the last price is used.")
data class PercentPriceFilter(
@ApiModelProperty("Multiplier up.")
@JsonProperty("multiplierUp") var multiplierUp:String?=null,
@ApiModelProperty("Multiplier down.")
@JsonProperty("multiplierDown") var multiplierDown:String?=null,
@ApiModelProperty("Weighted average price.")
@JsonProperty("avgPriceMins") var avgPriceMins:String?=null)
{
}