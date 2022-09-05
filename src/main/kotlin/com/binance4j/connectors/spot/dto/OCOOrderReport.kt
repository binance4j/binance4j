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
 * OCO order report.
 *
 * @property symbol              Symbol.
 * @property orderId             Order Id.
 * @property orderListId         Order List Id.
 * @property clientOrderId       Client Order Id.
 * @property transactTime        Transact Time.
 * @property price               Price.
 * @property origQty             Original Quantity.
 * @property executedQty         Executed Quantity.
 * @property cummulativeQuoteQty Cumulative Quote Quantity.
 * @property status              Status.
 * @property timeInForce         Time In Force.
 * @property type                Type.
 * @property side                Side.
 * @property stopPrice           StopPrice.
 */
@ApiModel("OCO order report.")
data class OCOOrderReport(
	@ApiModelProperty("Symbol.")
	@JsonProperty("symbol")
	var symbol: String,
	@ApiModelProperty("Order Id.")
	@JsonProperty("orderId")
	var orderId: Long,
	@ApiModelProperty("Order List Id.")
	@JsonProperty("orderListId")
	var orderListId: Long,
	@ApiModelProperty("Client Order Id.")
	@JsonProperty("clientOrderId")
	var clientOrderId: String,
	@ApiModelProperty("Transact Time.")
	@JsonProperty("transactTime")
	var transactTime: Long,
	@ApiModelProperty("Price.")
	@JsonProperty("price")
	var price: String,
	@ApiModelProperty("Original Quantity.")
	@JsonProperty("origQty")
	var origQty: String,
	@ApiModelProperty("Executed Quantity.")
	@JsonProperty("executedQty")
	var executedQty: String,
	@ApiModelProperty("Cummulative Quote Quantity.")
	@JsonProperty("cummulativeQuoteQty")
	var cummulativeQuoteQty: String,
	@ApiModelProperty("Status.")
	@JsonProperty("status")
	var status: String,
	@ApiModelProperty("Time In Force.")
	@JsonProperty("timeInForce")
	var timeInForce: String,
	@ApiModelProperty("Type.")
	@JsonProperty("type")
	var type: String,
	@ApiModelProperty("Side.")
	@JsonProperty("side")
	var side: String,
	@ApiModelProperty("StopPrice.")
	@JsonProperty("stopPrice")
	var stopPrice: String
)

