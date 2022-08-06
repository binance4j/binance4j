package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Wraps a symbol and its corresponding latest price.
 * 
 * @param symbol Ticker symbol.
 * @param price  Latest price.
 */
@ApiModel("Wraps a symbol and its corresponding latest price.")
public record PriceTicker(@ApiModelProperty("Ticker symbol.") String symbol, @ApiModelProperty("Latest price.") String price) {
}
