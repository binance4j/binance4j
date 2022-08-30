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
	val eventType: String
	@ApiModelProperty("Timestamp.")
@JsonProperty("E")
val eventTime: Long,

@ApiModelProperty("Trading pair.")
@JsonProperty("s")
val symbol: String,
@ApiModelProperty("Price change.")
@JsonProperty("p")
val priceChange: String,
@ApiModelProperty("Price change percent.")
@JsonProperty("P")
val priceChangePercent: String,
@ApiModelProperty("Weighted average price.")
@JsonProperty("w")
val weightedAveragePrice: String,
@ApiModelProperty("Previous days close price.")
@JsonProperty("x")
val previousDaysClosePrice: String,
@ApiModelProperty("Current days close price.")
@JsonProperty("c")
val currentDaysClosePrice: String,
@ApiModelProperty("Last quantity.")
@JsonProperty("Q")
val closeTradesQuantity: String,
@ApiModelProperty("Best bid price.")
@JsonProperty("b")
val bestBidPrice: String,
@ApiModelProperty("Best bid quantity.")
@JsonProperty("B")
val bestBidQuantity: String,
@ApiModelProperty("Best ask price.")
@JsonProperty("a")
val bestAskPrice: String,
@ApiModelProperty("Best ask quantity.")
@JsonProperty("A")
val bestAskQuantity: String,
@ApiModelProperty("Open price.")
@JsonProperty("o")
val openPrice: String,
@ApiModelProperty("Highest price.")
@JsonProperty("h")
val highPrice: String,
@ApiModelProperty("Lowest price.")
@JsonProperty("l")
val lowPrice: String,
@ApiModelProperty("Total traded base asset volume.")
@JsonProperty("v")
val totalTradedBaseAssetVolume: String,
@ApiModelProperty("Total traded quote asset volume.")
@JsonProperty("q")
val totalTradedQuoteAssetVolume: String,
@ApiModelProperty("Statistics open time.")
@JsonProperty("O")
val statisticsOpenTime: Long,

@ApiModelProperty("Statistics close time.")
@JsonProperty("C")
val statisticsCloseTime: Long,

@ApiModelProperty("First trade ID.")
@JsonProperty("F")
val firstTradeId: Long,

@ApiModelProperty("Last trade Id.")
@JsonProperty("L")
val lastTradeId: Long,

@ApiModelProperty("Total number of trades.")
@JsonProperty("n")
val totalNumberOfTrade: Long,
)