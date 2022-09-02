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

package com.binance4j.spot.dto

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
	var symbol: String,
	@ApiModelProperty("Order Id.")
	var orderId: Long,
	@ApiModelProperty("Order List Id.")
	var orderListId: Long,
	@ApiModelProperty("Client Order Id.")
	var clientOrderId: String,
	@ApiModelProperty("Transact Time.")
	var transactTime: Long,
	@ApiModelProperty("Price.")
	var price: String,
	@ApiModelProperty("Original Quantity.")
	var origQty: String,
	@ApiModelProperty("Executed Quantity.")
	var executedQty: String,
	@ApiModelProperty("Cummulative Quote Quantity.")
	var cummulativeQuoteQty: String,
	@ApiModelProperty("Status.")
	var status: String,
	@ApiModelProperty("Time In Force.")
	var timeInForce: String,
	@ApiModelProperty("Type.")
	var type: String,
	@ApiModelProperty("Side.")
	var side: String,
	@ApiModelProperty("StopPrice.")
	var stopPrice: String
)

