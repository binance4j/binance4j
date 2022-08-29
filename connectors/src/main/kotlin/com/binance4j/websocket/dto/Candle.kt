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

import com.binance4j.websocket.serialization.CandlestickEventDeserializer
import com.binance4j.websocket.serialization.CandlestickEventSerializer
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonFormat.Shape
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Kline/candle for a symbol.
 *
 * @property openTime                 Candlestick open timestamp in milliseconds
 * @property open                     Open value
 * @property high                     High value
 * @property low                      Low value
 * @property close                    Close value
 * @property volume                   Traded volume in the interval
 * @property closeTime                Candlestick close timestamp in milliseconds
 * @property quoteAssetVolume         Quote asset traded volume
 * @property numberOfTrades           Number of trades
 * @property takerBuyBaseAssetVolume  Taker buy base asset volume
 * @property takerBuyQuoteAssetVolume Taker buy quote asset volume
 * @property eventType                Event type.
 * @property eventTime                Timestamp in ms.
 * @property symbol                   Trading pair.
 * @property intervalId               Interval id.
 * @property firstTradeId             First trade id.
 * @property lastTradeId              Last trade id.
 * @property isBarFinal               Is it the last bar of the interval?
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFormat(shape = Shape.OBJECT)
@JsonDeserialize(using = CandlestickEventDeserializer::class)
@JsonSerialize(using = CandlestickEventSerializer::class)
@ApiModel("Kline/candle for a symbol.")
data class Candle(
	@ApiModelProperty("Candlestick open timestamp in milliseconds")
	val openTime: Long,
	
	@ApiModelProperty("Open value")
	val open: String,
	
	@ApiModelProperty("High value")
	val high: String,
	
	@ApiModelProperty("Low value")
	val low: String,
	
	@ApiModelProperty("Close value")
	val close: String,
	
	@ApiModelProperty("Traded volume in the interval")
	val volume: String,
	
	@ApiModelProperty("Candlestick close timestamp in milliseconds")
	val closeTime: Long,
	
	@ApiModelProperty("Quote asset traded volume")
	val quoteAssetVolume: String,
	
	@ApiModelProperty("Number of trades")
	val numberOfTrades: Long,
	
	@ApiModelProperty("Taker buy base asset volume")
	val takerBuyBaseAssetVolume: String,
	
	@ApiModelProperty("Taker buy quote asset volume")
	val takerBuyQuoteAssetVolume: String,
	
	@ApiModelProperty("Event type.")
	val eventType: String,
	
	@ApiModelProperty("Timestamp in ms.")
	val eventTime: Long,
	
	@ApiModelProperty("Trading pair.")
	val symbol: String,
	
	@ApiModelProperty("Interval id.")
	val intervalId: String,
	
	@ApiModelProperty("First trade id.")
	val firstTradeId: Long,
	
	@ApiModelProperty("Last trade id.")
	val lastTradeId: Long,
	
	@ApiModelProperty("Is it the last bar of the interval?")
	val isBarFinal: Boolean
)