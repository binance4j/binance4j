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
 * Pair trade data.
 *
 * @property eventType          Event type.
 * @property eventTime          Timestamp.
 * @property symbol             Trading pair.
 * @property tradeId            Trade id.
 * @property price              Price.
 * @property quantity           Price.
 * @property buyerOrderId       Buyer order id.
 * @property sellerOrderId      Seller order id.
 * @property tradeTime          Timestamp.
 * @property buyerIsMarketMaker Is the buyer the market maker?
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Pair trade data.")
data class Trade(
	@ApiModelProperty("Event type.")
	@JsonProperty("e") var eventType: String,
	@ApiModelProperty("Timestamp.")
	@JsonProperty("E")
	var eventTime: Long,
	@ApiModelProperty("Trading pair.")
	@JsonProperty("s")
	var symbol: String,
	@ApiModelProperty("Trade id.")
	@JsonProperty("t")
	var tradeId: String,
	@ApiModelProperty("Price.")
	@JsonProperty("p")
	var price: String,
	@ApiModelProperty("Price.")
	@JsonProperty("q")
	var quantity: String,
	@ApiModelProperty("Buyer order id.")
	@JsonProperty("b")
	var buyerOrderId: Long,
	@ApiModelProperty("Seller order id.")
	@JsonProperty("a")
	var sellerOrderId: Long,
	@ApiModelProperty("Timestamp.")
	@JsonProperty("T")
	var tradeTime: Long,
	@ApiModelProperty("Is the buyer the market maker?")
	@JsonProperty("m")
	var buyerIsMarketMaker: Boolean
)