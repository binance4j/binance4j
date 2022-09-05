/*
 * MIT License
 *
 * Copyright (c) 2022 Binance4j
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.binance4j.connectors.vision.dto

import com.fasterxml.jackson.annotation.JsonProperty

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

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
data class VisionTrade(
	@ApiModelProperty("Trade id.")
	@JsonProperty("tradeId")
	var tradeId: Long,
	@ApiModelProperty("Time in ms.")
	@JsonProperty("time")
	var time: Long,
	@ApiModelProperty("Price.")
	@JsonProperty("price")
	var price: String,
	@ApiModelProperty("Quantity.")
	@JsonProperty("quantity")
	var quantity: String,
	@ApiModelProperty("Quote quantity.")
	@JsonProperty("quoteQuantity")
	var quoteQuantity: String,
	@ApiModelProperty("Was it a buyer maker.")
	@JsonProperty("isBuyerMaker")
	var isBuyerMaker: Boolean,
	@ApiModelProperty("Was it the best price match?")
	@JsonProperty("isBestMatch")
	var isBestMatch: Boolean
) {
	
	/**
	 * @property input A csv line in a list format
	 */
	constructor(input: List<String>) : this(
		input[0].toLong(), input[4].toLong(), input[1], input[2], input[3], input[5].toBoolean(), input[6].toBoolean()
	)
}
