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
 * An aggregated trade event for a symbol.
 *
 * @property aggregatedTradeId     Agg trade id.
 * @property price                 Price.
 * @property quantity              Volume.
 * @property firstBreakdownTradeId First trade id.
 * @property lastBreakdownTradeId  Last trade id.
 * @property tradeTime             Timestamp.
 * @property isBuyerMaker          Was the buyer the maker?
 * @property eventType             Event type.
 * @property eventTime             Timestamp.
 * @property symbol                Trading pair.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("An aggregated trade event for a symbol.")
data class AggTrade(
	@ApiModelProperty("Agg trade id.")
	@JsonProperty("a")
	var aggregatedTradeId: Long? = null,

	@ApiModelProperty("Price.")
	@JsonProperty("p")
	var price: String? = null,

	@ApiModelProperty("Volume.")
	@JsonProperty("q")
	var quantity: String? = null,

	@ApiModelProperty("First trade id.")
	@JsonProperty("f")
	var firstBreakdownTradeId: Long? = null,

	@ApiModelProperty("Last trade id.")
	@JsonProperty("l")
	var lastBreakdownTradeId: Long? = null,

	@ApiModelProperty("Timestamp.")
	@JsonProperty("T")
	var tradeTime: Long? = null,

	@ApiModelProperty("Was the buyer the maker?")
	@JsonProperty("m")
	var isBuyerMaker: Boolean? = null,

	@ApiModelProperty("Event type.")
	@JsonProperty("e")
	var eventType: String? = null,

	@ApiModelProperty("Timestamp.")
	@JsonProperty("E")
	var eventTime: Long? = null,

	@ApiModelProperty("Trading pair.")
	@JsonProperty("s")
	var symbol: String? = null
)