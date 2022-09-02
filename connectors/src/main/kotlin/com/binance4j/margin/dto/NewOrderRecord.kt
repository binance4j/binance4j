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
import com.binance4j.core.dto.Trade

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * An newly placed order record.
 *
 * @property orderId               Order id.
 * @property symbol                Traded symbol.
 * @property side                  Order side.
 * @property status                Order status.
 * @property type                  Order type.
 * @property timeInForce           Order time in force.
 * @property transactTime          Transaction time.
 * @property clientOrderId         Client order id.
 * @property price                 Symbol price.
 * @property origQty               Order original quantity.
 * @property executedQty           Order executed quantity.
 * @property cummulativeQuoteQty   Cumulative quote quantity.
 * @property marginBuyBorrowAmount Margin buy borrow amount. Will not return if no margin trade happens.
 * @property marginBuyBorrowAsset  Margin buy borrow asset. Will not return if no margin trade happens.
 * @property isIsolated            Is the order isolated?
 * @property fills                 Filled trades.
 */
@ApiModel("An newly placed order record.")
data class NewOrderRecord(
	@ApiModelProperty("Order id.")
	@JsonProperty("orderId")
	var orderId: Long,
	@ApiModelProperty("Traded symbol.")
	@JsonProperty("symbol")
	var symbol: String,
	@ApiModelProperty("Order side.")
	@JsonProperty("side")
	var side: OrderSide? = null,
	@ApiModelProperty("Order status.")
	@JsonProperty("status")
	var status: String,
	@ApiModelProperty("Order type.")
	@JsonProperty("type")
	var type: String,
	@ApiModelProperty("Order time in force.")
	@JsonProperty("timeInForce")
	var timeInForce: String,
	@ApiModelProperty("Transaction time.")
	@JsonProperty("transactTime")
	var transactTime: Long,
	@ApiModelProperty("Client order id.")
	@JsonProperty("clientOrderId")
	var clientOrderId: String,
	@ApiModelProperty("Symbol price.")
	@JsonProperty("price")
	var price: String,
	@ApiModelProperty("Order original quantity.")
	@JsonProperty("origQty")
	var origQty: String,
	@ApiModelProperty("Order executed quantity.")
	@JsonProperty("executedQty")
	var executedQty: String,
	@ApiModelProperty("Cumulative quote quantity.")
	@JsonProperty("cummulativeQuoteQty")
	var cummulativeQuoteQty: String,
	@ApiModelProperty("Margin buy borrow amount. Will not return if no margin trade happens.")
	@JsonProperty("marginBuyBorrowAmount")
	var marginBuyBorrowAmount: String,
	@ApiModelProperty("Margin buy borrow asset. Will not return if no margin trade happens.")
	@JsonProperty("marginBuyBorrowAsset")
	var marginBuyBorrowAsset: String,
	@ApiModelProperty("Is the order isolated?")
	@JsonProperty("isIsolated")
	var isIsolated: Boolean,
	@ApiModelProperty("Filled trades.")
	@JsonProperty("fills")
	var fills: List<Trade>
)