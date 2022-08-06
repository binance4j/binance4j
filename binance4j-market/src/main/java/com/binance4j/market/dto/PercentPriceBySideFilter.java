package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The valid range for the price based on the lastPrice of the symbol. There is a different range depending on whether
 * the order is placed on the BUY side or the SELL side.
 * 
 * @param bidMultiplierUp   Bid multiplier up.
 * @param bidMultiplierDown Bid multiplier down.
 * @param askMultiplierUp   Ask multiplier up.
 * @param askMultiplierDown Ask multiplier down.
 * @param avgPriceMins      Weighted average price.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a> *
 */
@ApiModel("The valid range for the price based on the lastPrice of the symbol. There is a different range depending on whether the order is placed on the BUY side or the SELL side.")
public record PercentPriceBySideFilter(@ApiModelProperty("Bid multiplier up.") String bidMultiplierUp,
		@ApiModelProperty("Bid multiplier down.") String bidMultiplierDown, @ApiModelProperty("Ask multiplier up.") String askMultiplierUp,
		@ApiModelProperty("Ask multiplier down.") String askMultiplierDown, @ApiModelProperty("Weighted average price.") String avgPriceMins) {
}