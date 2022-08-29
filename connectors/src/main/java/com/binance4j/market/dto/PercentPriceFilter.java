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
 val multiplierUp : String,
@ApiModelProperty("Multiplier down.")
 val multiplierDown : String,
@ApiModelProperty("Weighted average price.")
 val avgPriceMins : String)
{
}