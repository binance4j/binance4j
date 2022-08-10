package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The best price/quantity on the order book for a given symbol.
 * 
 * @param symbol   Ticker symbol.
 * @param bidPrice Bid price.
 * @param bidQty   Bid quantity.
 * @param askPrice Ask price.
 * @param askQty   Ask quantity.
 */
@ApiModel("The best price/quantity on the order book for a given symbol.")
public record BookTicker(@ApiModelProperty("Ticker symbol.") String symbol,
		@ApiModelProperty("Bid price.") String bidPrice,
		@ApiModelProperty("Bid quantity.") String bidQty, @ApiModelProperty("Ask price.") String askPrice,
		@ApiModelProperty("Ask quantity.") String askQty) {
}