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

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * The CancelOrder request result.
 *
 * @property status              Status.
 * @property side                Side.
 * @property type                Type.
 * @property timeInForce         Time in force.
 * @property orderId             Order id.
 * @property orderListId         Order list id.
 * @property symbol              Symbol.
 * @property origClientOrderId   Orig client order id.
 * @property clientOrderId       Client order id.
 * @property executedQty         Executed quantity.
 * @property price               Price.
 * @property origQty             Original quantity.
 * @property cummulativeQuoteQty Cumulative quote quantity.
 */
@ApiModel("The CancelOrder request result.")
data class CancelOrderResponse(
	@ApiModelProperty("Status.")
	@JsonProperty("status")
	var status: String,
	@ApiModelProperty("Side.")
	@JsonProperty("side")
	var side: String,
	@ApiModelProperty("Type.")
	@JsonProperty("type")
	var type: String,
	@ApiModelProperty("Time in force.")
	@JsonProperty("timeInForce")
	var timeInForce: String,
	@ApiModelProperty("Order id.")
	@JsonProperty("orderId")
	var orderId: Long,
	@ApiModelProperty("Order list id.")
	@JsonProperty("orderListId")
	var orderListId: Long,
	@ApiModelProperty("Symbol.")
	@JsonProperty("symbol")
	var symbol: String,
	@ApiModelProperty("Orig client order id.")
	@JsonProperty("origClientOrderId")
	var origClientOrderId: String,
	@ApiModelProperty("Client order id.")
	@JsonProperty("clientOrderId")
	var clientOrderId: String,
	@ApiModelProperty("Executed quantity.")
	@JsonProperty("executedQty")
	var executedQty: String,
	@ApiModelProperty("Price.")
	@JsonProperty("price")
	var price: String,
	@ApiModelProperty("Original quantity.")
	@JsonProperty("origQty")
	var origQty: String,
	@ApiModelProperty("Cummulative quote quantity.")
	@JsonProperty("cummulativeQuoteQty")
	var cummulativeQuoteQty: String
)