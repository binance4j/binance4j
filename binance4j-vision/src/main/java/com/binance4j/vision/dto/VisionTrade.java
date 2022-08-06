package com.binance4j.vision.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The representation of a trade.
 * 
 * @param tradeId       Was it a buyer maker.
 * @param time          Was it a buyer maker.
 * @param price         Was it a buyer maker.
 * @param quantity      Was it a buyer maker.
 * @param quoteQuantity Was it a buyer maker.
 * @param isBuyerMaker  Was it a buyer maker.
 * @param isBestMatch   Was it the best price match?
 */
@ApiModel("")
public record VisionTrade(@ApiModelProperty("") long tradeId, @ApiModelProperty("") long time, @ApiModelProperty("") String price,
		@ApiModelProperty("") String quantity, @ApiModelProperty("") String quoteQuantity, @ApiModelProperty("") boolean isBuyerMaker, @ApiModelProperty("")
		/** Was it the best price match? */
		boolean isBestMatch) {
	/**
	 * @param input A csv line in a list format
	 */
	public VisionTrade(List<String> input) {
		this(Long.parseLong(input.get(0)), Long.parseLong(input.get(4)), input.get(1), input.get(2), input.get(3), Boolean.parseBoolean(input.get(5)),
				Boolean.parseBoolean(input.get(6)));
	}
}
