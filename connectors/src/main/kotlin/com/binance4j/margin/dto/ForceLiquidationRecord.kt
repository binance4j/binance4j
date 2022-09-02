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

import com.fasterxml.jackson.annotation.JsonProperty

import com.binance4j.core.dto.OrderSide
import com.binance4j.core.dto.TimeInForce

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Market order to exit leveraged position.
 *
 * @property orderId     Order id.
 * @property updatedTime Liquidation timestamp in ms.
 * @property avgPrice    Symbol average price.
 * @property executedQty Executed quantity.
 * @property timeInForce Order time in force.
 * @property side        Order side.
 * @property symbol      Order symbol.
 * @property price       Order price.
 * @property qty         Order total quantity.
 * @property isIsolated  Is it isolated?
 */
@ApiModel("Market order to exit leveraged position.")
data class ForceLiquidationRecord(
	@ApiModelProperty("Order id.")
	@JsonProperty("orderId")
	var orderId: Long,
	@ApiModelProperty("Liquidation timestamp in ms.")
	@JsonProperty("updatedTime")
	var updatedTime: Long,
	@ApiModelProperty("Symbol average price.")
	@JsonProperty("avgPrice")
	var avgPrice: String,
	@ApiModelProperty("Executed quantity.")
	@JsonProperty("executedQty")
	var executedQty: String,
	@ApiModelProperty("Order time in force.")
	@JsonProperty("timeInForce")
	var timeInForce: TimeInForce? = null,
	@ApiModelProperty("Order side.")
	@JsonProperty("side")
	var side: OrderSide? = null,
	@ApiModelProperty("Order symbol.")
	@JsonProperty("symbol")
	var symbol: String,
	@ApiModelProperty("Order price.")
	@JsonProperty("price")
	var price: String,
	@ApiModelProperty("Order total quantity.")
	@JsonProperty("qty")
	var qty: String,
	@ApiModelProperty("Is it isolated?") @JsonProperty("isIsolated")
	var isIsolated: Boolean
)
