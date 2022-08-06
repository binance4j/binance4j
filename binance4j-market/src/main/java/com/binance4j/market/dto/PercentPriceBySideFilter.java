package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Defines the valid range for the price based on the lastPrice of the symbol. There is a different range depending on
 * whether the order is placed on the BUY side or the SELL side.
 * 
 * @param bidMultiplierUp   Bid multiplier up.
 * @param bidMultiplierDown Bid multiplier down.
 * @param askMultiplierUp   Ask multiplier up.
 * @param askMultiplierDown Ask multiplier down.
 * @param avgPriceMins      Weighted average price.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a> *
 */
@ApiModel("")
public record PercentPriceBySideFilter(@ApiModelProperty("") String bidMultiplierUp, @ApiModelProperty("") String bidMultiplierDown,
		@ApiModelProperty("") String askMultiplierUp, @ApiModelProperty("") String askMultiplierDown, @ApiModelProperty("") String avgPriceMins) {
}