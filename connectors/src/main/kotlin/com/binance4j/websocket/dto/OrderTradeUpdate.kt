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

import com.binance4j.core.dto.TimeInForce
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Order or trade report update event.
 * <p>
 * This event is embedded as part of a user data update event.
 *
 * @property eventType               Event type.
 * @property eventTime               Timestamp.
 * @property symbol                  Trading pair.
 * @property newClientOrderId        Client order id.
 * @property side                    Buy/Sell order side.
 * @property type                    Type of order.
 * @property timeInForce             Time in force to indicate how Long will the
 *                                order remain active.
 * @property originalQuantity        Original quantity in the order.
 * @property price                   Price.
 * @property executionType           Type of execution.
 * @property orderStatus             Status of the order.
 * @property orderRejectReason       Reason why the order was rejected.
 * @property orderId                 Order id.
 * @property quantityLastFilledTrade Quantity of the last filled trade.
 * @property accumulatedQuantity     Accumulated quantity of filled trades on this
 *                                order.
 * @property priceOfLastFilledTrade  Price of last filled trade.
 * @property commission              Commission.
 * @property commissionAsset         Asset on which commission is taken.
 * @property orderTradeTime          Order/trade time.
 * @property tradeId                 Trade id.
 * @property orderCreationTime       Order creation time.
 * @property cumulativeQuoteQuantity Cumulative quote asset transacted quantity.
 * @property lastQuoteQuantity       Last quote asset transacted quantity (i.e.
 *                                lastPrice * lastQty).
 * @property quoteOrderQuantity      Quote Order quantity.
 * @see UserDataUpdate
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Order or trade report update event.")
data class OrderTradeUpdate(
	@ApiModelProperty("Event type.")
	@JsonProperty("e")
	var eventType: String = "",

	@ApiModelProperty("Timestamp.")
	@JsonProperty("E")
	var eventTime: Long = 0L,

	@ApiModelProperty("Trading pair.")
	@JsonProperty("s")
	var symbol: String = "",

	@ApiModelProperty("Client order id.")
	@JsonProperty("c")
	var newClientOrderId: String = "",

	@ApiModelProperty("Buy/Sell order side.")
	@JsonProperty("S")
	var side: String = "",

	@ApiModelProperty("Type of order.")
	@JsonProperty("o")
	var type: String = "",

	@ApiModelProperty("Time in force to indicate how Long will the order remain active.")
	@JsonProperty("f")
	var timeInForce: TimeInForce? = null,

	@ApiModelProperty("Original quantity in the order.")
	@JsonProperty("q")
	var originalQuantity: String = "",

	@ApiModelProperty("Price.")
	@JsonProperty("p")
	var price: String = "",

	@ApiModelProperty("Type of execution.")
	@JsonProperty("x")
	var executionType: String = "",

	@ApiModelProperty("Status of the order.")
	@JsonProperty("X")
	var orderStatus: String = "",

	@ApiModelProperty("Reason why the order was rejected.")
	@JsonProperty("r")
	var orderRejectReason: String = "",

	@ApiModelProperty("Order id.")
	@JsonProperty("i")
	var orderId: Long = 0L,

	@ApiModelProperty("Quantity of the last filled trade.")
	@JsonProperty("l")
	var quantityLastFilledTrade: String = "",

	@ApiModelProperty("Accumulated quantity of filled trades on this order.")
	@JsonProperty("z")
	var accumulatedQuantity: String = "",

	@ApiModelProperty("Price of last filled trade.")
	@JsonProperty("L")
	var priceOfLastFilledTrade: String = "",

	@ApiModelProperty("Commission.")
	@JsonProperty("n")
	var commission: String = "",

	@ApiModelProperty("Asset on which commission is taken.")
	@JsonProperty("N")
	var commissionAsset: String = "",

	@ApiModelProperty("Order/trade time.")
	@JsonProperty("T")
	var orderTradeTime: Long = 0L,

	@ApiModelProperty("Trade id.")
	@JsonProperty("t")
	var tradeId: Long = 0L,

	@ApiModelProperty("Order creation time.")
	@JsonProperty("O")
	var orderCreationTime: Long = 0L,

	@ApiModelProperty("Cumulative quote asset transacted quantity.")
	@JsonProperty("Z")
	var cumulativeQuoteQuantity: String = "",

	@ApiModelProperty("Last quote asset transacted quantity (i.e. lastPrice * lastQty).")
	@JsonProperty("Y")
	var lastQuoteQuantity: String = "",

	@ApiModelProperty("Quote Order quantity.")
	@JsonProperty("Q")
	var quoteOrderQuantity: String = ""
)