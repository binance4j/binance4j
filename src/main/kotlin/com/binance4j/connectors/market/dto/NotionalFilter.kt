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

package com.binance4j.connectors.market.dto

import com.fasterxml.jackson.annotation.JsonProperty

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * The acceptable notional range allowed for an order on a symbol.
 *
 * @property maxNotional      Minimum notional value allowed for an order on a
 *                         symbol. An order's notional value is the.
 *                         price * quantity.
 * @property applyMinToMarket Maximum notional value allowed for an order on a
 *                         symbol. An order's notional value is the.
 *                         price * quantity.
 * @property applyMaxToMarket Determines whether the minNotional will be applied to
 *                         MARKET orders.
 * @property avgPriceMins     determines whether the maxNotional will be applied to
 *                         MARKET orders.
 * @property minNotional      Number of minutes the average price is calculated
 *                         over. 0 means the last price is used.
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@ApiModel("The acceptable notional range allowed for an order on a symbol.")
data class NotionalFilter(
	@ApiModelProperty("The minimum notional value allowed for an order on a symbol. An order's notional value is the. price * quantity.")
	@JsonProperty("minNotional")
	var minNotional: String,
	@ApiModelProperty("The maximum notional value allowed for an order on a symbol. An order's notional value is the. price * quantity.")
	@JsonProperty("maxNotional")
	var maxNotional: String,
	@ApiModelProperty("Determines whether the minNotional will be applied to MARKET orders.")
	@JsonProperty("applyMinToMarket")
	var applyMinToMarket: Boolean,
	@ApiModelProperty(" determines whether the maxNotional will be applied to MARKET orders.")
	@JsonProperty("applyMaxToMarket")
	var applyMaxToMarket: Boolean,
	@ApiModelProperty("Number of minutes the average price is calculated over. 0 means the last price is used.")
	@JsonProperty("avgPriceMins")
	var avgPriceMins: Int
)