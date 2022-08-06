package com.binance4j.vision.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A trade.
 * 
 * @param tradeId       Trade id.
 * @param time          Time in ms.
 * @param price         Price.
 * @param quantity      Quantity.
 * @param quoteQuantity Quote quantity.
 * @param isBuyerMaker  Was it a buyer maker.
 * @param isBestMatch   Was it the best price match?
 */
@ApiModel("A trade.")
public record VisionTrade(@ApiModelProperty("Trade id.") long tradeId, @ApiModelProperty("Time in ms.") long time, @ApiModelProperty("Price.") String price,
		@ApiModelProperty("Quantity.") String quantity, @ApiModelProperty("Quote quantity.") String quoteQuantity,
		@ApiModelProperty("Was it a buyer maker.") boolean isBuyerMaker, @ApiModelProperty("Was it the best price match?") boolean isBestMatch) {
	/**
	 * @param input A csv line in a list format
	 */
	public VisionTrade(List<String> input) {
		this(Long.parseLong(input.get(0)), Long.parseLong(input.get(4)), input.get(1), input.get(2), input.get(3), Boolean.parseBoolean(input.get(5)),
				Boolean.parseBoolean(input.get(6)));
	}
}
