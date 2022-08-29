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

package com.binance4j.websocket.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * BookTickerEvent event for a symbol. Pushes any update to the best bid or ask
 * price or quantity in real-time for a
 * specified symbol.
 *
 * @property updateId    Update id.
 * @property symbol      Trading pair.
 * @property bidPrice    Bid price.
 * @property bidQuantity Bid quantity.
 * @property askPrice    Ask price.
 * @property askQuantity Ask quantity.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("BookTickerEvent event for a symbol. Pushes any update to the best bid or ask price or quantity in real-time for a specified symbol.")
data class BookTicker(
	@ApiModelProperty("Update id.")
	@JsonProperty("u")
	val updateId: Long,
	
	@ApiModelProperty("Trading pair.")
	@JsonProperty("s")
	val symbol: String,
	
	@ApiModelProperty("Bid price.")
	@JsonProperty("b")
	val bidPrice: String,
	
	@ApiModelProperty("Bid quantity.")
	@JsonProperty("B")
	val bidQuantity: String,
	
	@ApiModelProperty("Ask price.")
	@JsonProperty("a")
	val askPrice: String,
	
	@ApiModelProperty("Ask quantity.")
	@JsonProperty("A")
	val askQuantity: String
)