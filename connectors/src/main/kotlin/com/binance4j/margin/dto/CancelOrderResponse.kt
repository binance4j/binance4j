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

package com.binance4j.margin.dto

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
 * @property isIsolated          Is isolated.
 */
@ApiModel("The CancelOrder request result.")
data class CancelOrderResponse(
	@ApiModelProperty("Status.")
	val status: String,
	@ApiModelProperty("Side.")
	val side: String,
	@ApiModelProperty("Type.")
	val type: String,
	@ApiModelProperty("Time in force.")
	val timeInForce: String,
	@ApiModelProperty("Order id.")
	val orderId: Long,
	@ApiModelProperty("Order list id.")
	val orderListId: Long,
	@ApiModelProperty("Symbol.")
	val symbol: String,
	@ApiModelProperty("Orig client order id.")
	val origClientOrderId: String,
	@ApiModelProperty("Client order id.")
	val clientOrderId: String,
	@ApiModelProperty("Executed quantity.")
	val executedQty: String,
	@ApiModelProperty("Price.")
	val price: String,
	@ApiModelProperty("Original quantity.")
	val origQty: String,
	@ApiModelProperty("Cumulative quote quantity.")
	val cummulativeQuoteQty: String,
	@ApiModelProperty("Is isolated.")
	val isIsolated: Boolean
)