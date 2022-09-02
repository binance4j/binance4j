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

package com.binance4j.market.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 24 hour price change statistics for a ticker.
 *
 * @property symbol             Ticker symbol.
 * @property priceChange        Price change during the last 24 hours.
 * @property priceChangePercent Price change; in percentage; during the last 24
 *                           hours.
 * @property weightedAvgPrice   Weighted average price.
 * @property prevClosePrice     Previous close price.
 * @property lastPrice          Last price.
 * @property lastQty            Last quantity.
 * @property bidPrice           Bid price.
 * @property bidQty             Bid quantity.
 * @property askPrice           Ask price.
 * @property askQty             Ask quantity.
 * @property openPrice          Open price 24 hours ago.
 * @property highPrice          Highest price during the past 24 hours.
 * @property lowPrice           Lowest price during the past 24 hours.
 * @property volume             Total volume during the past 24 hours.
 * @property quoteVolume        Total quote volume during the past 24 hours.
 * @property openTime           Open time.
 * @property closeTime          Close time.
 * @property firstId            First trade id.
 * @property lastId             Last trade id.
 * @property count              Total number of trades during the last 24 hours.
 */
@ApiModel("24 hour price change statistics for a ticker.")
data class TickerStatistics(
	@ApiModelProperty("Ticker symbol.")
	var symbol: String,
	@ApiModelProperty("Price change during the last 24 hours.")
	var priceChange: String,
	@ApiModelProperty("Price change; in percentage; during the last 24 hours.")
	var priceChangePercent: String,
	@ApiModelProperty("Weighted average price.")
	var weightedAvgPrice: String,
	@ApiModelProperty("Previous close price.")
	var prevClosePrice: String,
	@ApiModelProperty("Last price.")
	var lastPrice: String,
	@ApiModelProperty("Last quantity.")
	var lastQty: String,
	@ApiModelProperty("Bid price.")
	var bidPrice: String,
	@ApiModelProperty("Bid quantity.")
	var bidQty: String,
	@ApiModelProperty("Ask price.")
	var askPrice: String,
	@ApiModelProperty("Ask quantity.")
	var askQty: String,
	@ApiModelProperty("Open price 24 hours ago.")
	var openPrice: String,
	@ApiModelProperty("Highest price during the past 24 hours.")
	var highPrice: String,
	@ApiModelProperty("Lowest price during the past 24 hours.")
	var lowPrice: String,
	@ApiModelProperty("Total volume during the past 24 hours.")
	var volume: String,
	@ApiModelProperty("Total quote volume during the past 24 hours.")
	var quoteVolume: String,
	@ApiModelProperty("Open time.")
	var openTime: Long,
	@ApiModelProperty("Close time.")
	var closeTime: Long,
	@ApiModelProperty("First trade id.")
	var firstId: Long,
	@ApiModelProperty("Last trade id.")
	var lastId: Long,
	@ApiModelProperty("Total number of trades during the last 24 hours.")
	var count: Long,
)