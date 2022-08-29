package com.binance4j.vision.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A trade.
 * 
 * @property tradeId       Trade id.
 * @property time          Time in ms.
 * @property price         Price.
 * @property quantity      Quantity.
 * @property quoteQuantity Quote quantity.
 * @property isBuyerMaker  Was it a buyer maker.
 * @property isBestMatch   Was it the best price match?
 */
@ApiModel("A trade.")
data class VisionTrade(@ApiModelProperty("Trade id.")
@JsonProperty("tradeId") var tradeId: Long = 0L,
@ApiModelProperty("Time in ms.")
@JsonProperty("time") var time: Long = 0L,
@ApiModelProperty("Price.")
@JsonProperty("price") var price: String = "",
@ApiModelProperty("Quantity.")
@JsonProperty("quantity") var quantity: String = "",
@ApiModelProperty("Quote quantity.")
@JsonProperty("quoteQuantity") var quoteQuantity: String = "",
@ApiModelProperty("Was it a buyer maker.")
@JsonProperty("isBuyerMaker") var isBuyerMaker: Boolean = false,
@ApiModelProperty("Was it the best price match?")
@JsonProperty("isBestMatch") var isBestMatch: Boolean = false)
{

	/**
	 * @property input A csv line in a list format
	 */
	public VisionTrade(List<String> input) {
		this(Long.parseLong(input.get(0)), Long.parseLong(input.get(4)), input.get(1), input.get(2), input.get(3),
				Boolean.parseBoolean(input.get(5)),
				Boolean.parseBoolean(input.get(6)));
	}
}
