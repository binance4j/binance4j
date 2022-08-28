package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The valid range for the price based on the lastPrice of the symbol. There is
 * a different range depending on whether
 * the order is placed on the BUY side or the SELL side.
 * 
 * @property bidMultiplierUp   Bid multiplier up.
 * @property bidMultiplierDown Bid multiplier down.
 * @property askMultiplierUp   Ask multiplier up.
 * @property askMultiplierDown Ask multiplier down.
 * @property avgPriceMins      Weighted average price.
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 *      *
 */
@ApiModel("The valid range for the price based on the lastPrice of the symbol. There is a different range depending on whether the order is placed on the BUY side or the SELL side.")
data class PercentPriceBySideFilter(
@ApiModelProperty("Bid multiplier up.")
@JsonProperty("bidMultiplierUp") var bidMultiplierUp:String?=null,
@ApiModelProperty("Bid multiplier down.")
@JsonProperty("bidMultiplierDown") var bidMultiplierDown:String?=null,
@ApiModelProperty("Ask multiplier up.")
@JsonProperty("askMultiplierUp") var askMultiplierUp:String?=null,
@ApiModelProperty("Ask multiplier down.")
@JsonProperty("askMultiplierDown") var askMultiplierDown:String?=null,
@ApiModelProperty("Weighted average price.")
@JsonProperty("avgPriceMins") var avgPriceMins:String?=null)
{
}