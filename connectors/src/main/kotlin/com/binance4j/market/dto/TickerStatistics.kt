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
	val symbol: String,
	
	@ApiModelProperty("Price change during the last 24 hours.")
	val priceChange: String,
	
	@ApiModelProperty("Price change; in percentage; during the last 24 hours.")
	val priceChangePercent: String,
	
	@ApiModelProperty("Weighted average price.")
	val weightedAvgPrice: String,
	
	@ApiModelProperty("Previous close price.")
	val prevClosePrice: String,
	
	@ApiModelProperty("Last price.")
	val lastPrice: String,
	
	@ApiModelProperty("Last quantity.")
	val lastQty: String,
	
	@ApiModelProperty("Bid price.")
	val bidPrice: String,
	
	@ApiModelProperty("Bid quantity.")
	val bidQty: String,
	
	@ApiModelProperty("Ask price.")
	val askPrice: String,
	
	@ApiModelProperty("Ask quantity.")
	val askQty: String,
	
	@ApiModelProperty("Open price 24 hours ago.")
	val openPrice: String,
	
	@ApiModelProperty("Highest price during the past 24 hours.")
	val highPrice: String,
	
	@ApiModelProperty("Lowest price during the past 24 hours.")
	val lowPrice: String,
	
	@ApiModelProperty("Total volume during the past 24 hours.")
	val volume: String,
	
	@ApiModelProperty("Total quote volume during the past 24 hours.")
	val quoteVolume: String,
	
	@ApiModelProperty("Open time.")
	val openTime: Long,
	
	@ApiModelProperty("Close time.")
	val closeTime: Long,
	
	@ApiModelProperty("First trade id.")
	val firstId: Long,
	
	@ApiModelProperty("Last trade id.")
	val lastId: Long,
	
	@ApiModelProperty("Total number of trades during the last 24 hours.")
	val count: Long
)
