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

package com.binance4j.connectors.websocket.dto


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Pair ticker.
 *
 * @property eventType                   Event type.
 * @property eventTime                   Timestamp.
 * @property symbol                      Trading pair.
 * @property priceChange                 Price change.
 * @property priceChangePercent          Price change percent.
 * @property weightedAveragePrice        Weighted average price.
 * @property previousDaysClosePrice      Previous days close price.
 * @property currentDaysClosePrice       Current days close price.
 * @property closeTradesQuantity         Last quantity.
 * @property bestBidPrice                Best bid price.
 * @property bestBidQuantity             Best bid quantity.
 * @property bestAskPrice                Best ask price.
 * @property bestAskQuantity             Best ask quantity.
 * @property openPrice                   Open price.
 * @property highPrice                   Highest price.
 * @property lowPrice                    Lowest price.
 * @property totalTradedBaseAssetVolume  Total traded base asset volume.
 * @property totalTradedQuoteAssetVolume Total traded quote asset volume.
 * @property statisticsOpenTime          Statistics open time.
 * @property statisticsCloseTime         Statistics close time.
 * @property firstTradeId                First trade ID.
 * @property lastTradeId                 Last trade ID.
 * @property totalNumberOfTrade          Total number of trades.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Pair ticker.")
data class Ticker(
	@ApiModelProperty("Event type.")
	@JsonProperty("e")
	var eventType: String,
	@ApiModelProperty("Timestamp.")
	@JsonProperty("E")
	var eventTime: Long,
	@ApiModelProperty("Trading pair.")
	@JsonProperty("s")
	var symbol: String,
	@ApiModelProperty("Price change.")
	@JsonProperty("p")
	var priceChange: String,
	@ApiModelProperty("Price change percent.")
	@JsonProperty("P")
	var priceChangePercent: String,
	@ApiModelProperty("Weighted average price.")
	@JsonProperty("w")
	var weightedAveragePrice: String,
	@ApiModelProperty("Previous days close price.")
	@JsonProperty("x")
	var previousDaysClosePrice: String,
	@ApiModelProperty("Current days close price.")
	@JsonProperty("c")
	var currentDaysClosePrice: String,
	@ApiModelProperty("Last quantity.")
	@JsonProperty("Q")
	var closeTradesQuantity: String,
	@ApiModelProperty("Best bid price.")
	@JsonProperty("b")
	var bestBidPrice: String,
	@ApiModelProperty("Best bid quantity.")
	@JsonProperty("B")
	var bestBidQuantity: String,
	@ApiModelProperty("Best ask price.")
	@JsonProperty("a")
	var bestAskPrice: String,
	@ApiModelProperty("Best ask quantity.")
	@JsonProperty("A")
	var bestAskQuantity: String,
	@ApiModelProperty("Open price.")
	@JsonProperty("o")
	var openPrice: String,
	@ApiModelProperty("Highest price.")
	@JsonProperty("h")
	var highPrice: String,
	@ApiModelProperty("Lowest price.")
	@JsonProperty("l")
	var lowPrice: String,
	@ApiModelProperty("Total traded base asset volume.")
	@JsonProperty("v")
	var totalTradedBaseAssetVolume: String,
	@ApiModelProperty("Total traded quote asset volume.")
	@JsonProperty("q")
	var totalTradedQuoteAssetVolume: String,
	@ApiModelProperty("Statistics open time.")
	@JsonProperty("O")
	var statisticsOpenTime: Long,
	@ApiModelProperty("Statistics close time.")
	@JsonProperty("C")
	var statisticsCloseTime: Long,
	@ApiModelProperty("First trade ID.")
	@JsonProperty("F")
	var firstTradeId: Long,
	@ApiModelProperty("Last trade Id.")
	@JsonProperty("L")
	var lastTradeId: Long,
	@ApiModelProperty("Total number of trades.")
	@JsonProperty("n")
	var totalNumberOfTrade: Long,
)