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

package com.binance4j.connectors.websocket.dto

import com.binance4j.connectors.core.dto.OrderBookEntry
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * The symbol order book.
 *
 * @property eventType     Event type.
 * @property eventTime     Timestamp.
 * @property symbol        Trading pair.
 * @property firstUpdateId First update id.
 * @property finalUpdateId Last update id.
 * @property bids          Offers.
 * @property asks          Demands.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("The symbol order book.")
data class Depth(
	@ApiModelProperty("Event type.")
	@JsonProperty("e")
	var eventType: String,
	@ApiModelProperty("Timestamp.")
	@JsonProperty("E")
	var eventTime: Long,
	@ApiModelProperty("Trading pair.")
	@JsonProperty("s")
	var symbol: String,
	@ApiModelProperty("First update id.")
	@JsonProperty("U")
	var firstUpdateId: Long,
	@ApiModelProperty("Last update id.")
	@JsonProperty("u")
	var finalUpdateId: Long,
	@ApiModelProperty("Offers.")
	@JsonProperty("b")
	var bids: List<OrderBookEntry>,
	@ApiModelProperty("Demands.")
	@JsonProperty("a")
	var asks: List<OrderBookEntry>
)