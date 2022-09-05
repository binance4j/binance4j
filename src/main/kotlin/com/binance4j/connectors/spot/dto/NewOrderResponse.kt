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

package com.binance4j.connectors.spot.dto

import com.fasterxml.jackson.annotation.JsonProperty

import com.binance4j.connectors.spot.client.SpotClient
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * [SpotClient.newOrder] response.
 *
 * @property symbol              Trading pair to trade.
 * @property orderId             Order id.
 * @property orderListId         Order list id.
 * @property clientOrderId       Client order id.
 * @property transactTime        Order transaction timestamp.
 * @property price               Price of trade.
 * @property origQty             Original traded quantity.
 * @property executedQty         Current executed quantity.
 * @property cummulativeQuoteQty Opposite coin quantity.
 * @property status              Order status.
 * @property timeInForce         How long the order will remain active.
 * @property type                Order type.
 * @property side                Order side.
 * @property fills               List of trades that partially of fully filled the order.
 */
@ApiModel("New order response.")
data class NewOrderResponse(
	@ApiModelProperty("Trading pair to trade.")
	@JsonProperty("symbol")
	var symbol: String,
	@ApiModelProperty("Order id.")
	@JsonProperty("orderId")
	var orderId: Long,
	@ApiModelProperty("Order list id.")
	@JsonProperty("orderListId")
	var orderListId: Long,
	@ApiModelProperty("Client order id.")
	@JsonProperty("clientOrderId")
	var clientOrderId: String,
	@ApiModelProperty("Order transaction timestamp.")
	@JsonProperty("transactTime")
	var transactTime: Long,
	@ApiModelProperty("Price of trade.")
	@JsonProperty("price")
	var price: String,
	@ApiModelProperty("Original traded quantity.")
	@JsonProperty("origQty")
	var origQty: String,
	@ApiModelProperty("Current executed quantity.")
	@JsonProperty("executedQty")
	var executedQty: String,
	@ApiModelProperty("Opposite coin quantity.")
	@JsonProperty("cummulativeQuoteQty")
	var cummulativeQuoteQty: String,
	@ApiModelProperty("Order status.")
	@JsonProperty("status")
	var status: String,
	@ApiModelProperty("How long the order will remain active.")
	@JsonProperty("timeInForce")
	var timeInForce: String,
	@ApiModelProperty("Order type.")
	@JsonProperty("type")
	var type: String,
	@ApiModelProperty("Order side.")
	@JsonProperty("side")
	var side: String,
	@ApiModelProperty("List of trades that partially of fully filled the order.")
	@JsonProperty("fills")
	var fills: List<OrderTrade>
)
