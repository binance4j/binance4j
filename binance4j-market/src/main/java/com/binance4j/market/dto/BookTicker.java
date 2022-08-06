package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents the best price/quantity on the order book for a given symbol.
 * 
 * @param symbol   Ticker symbol.
 * @param bidPrice Bid price.
 * @param bidQty   Bid quantity.
 * @param askPrice Ask price.
 * @param askQty   Ask quantity.
 */
@ApiModel("")
public record BookTicker(@ApiModelProperty("") String symbol, @ApiModelProperty("") String bidPrice, @ApiModelProperty("") String bidQty,
		@ApiModelProperty("") String askPrice, @ApiModelProperty("") String askQty) {
}