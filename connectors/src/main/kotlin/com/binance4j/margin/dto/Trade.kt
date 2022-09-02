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
 * A trade being part of a {@link NewOrderRecord}.
 *
 * @property id              Trade id.
 * @property orderId         Related order id.
 * @property symbol          Traded symbol.
 * @property commissionAsset Commission asset .
 * @property commission      Commission amount.
 * @property price           Trade price.
 * @property qty             Traded quantity.
 * @property time            Transaction time.
 * @property isBestMatch     Is it the best match?
 * @property isBuyer         Is it a buyer trade?
 * @property isMaker         Is it a maker trade?
 * @property isIsolated      Is it an isolated trade?
 */
@ApiModel("A trade being part of a NewOrderRecord.")
data class Trade(
	@ApiModelProperty("Trade id.")
	var id: Long,
	@ApiModelProperty("Related order id.")
	var orderId: Long,
	@ApiModelProperty("Traded symbol.")
	var symbol: String,
	@ApiModelProperty("Commission asset .")
	var commissionAsset: String,
	@ApiModelProperty("Commission amount.")
	var commission: String,
	@ApiModelProperty("Trade price.")
	var price: String,
	@ApiModelProperty("Traded quantity.")
	var qty: String,
	@ApiModelProperty("Transaction time.")
	var time: Long,
	@ApiModelProperty("Is it the best match?")
	var isBestMatch: Boolean,
	@ApiModelProperty("Is it a buyer trade?")
	var isBuyer: Boolean,
	@ApiModelProperty("Is it a maker trade?")
	var isMaker: Boolean,
	@ApiModelProperty("Is it an isolated trade?")
	var isIsolated: Boolean
)