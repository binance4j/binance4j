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

package com.binance4j.core.dto

import com.binance4j.core.serialization.CandleDeserializer
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * An ohlc candle for a symbol.
 *
 * @property openTime                 Candlestick open timestamp in milliseconds.
 * @property open                     Open value.
 * @property high                     High value.
 * @property low                      Low value.
 * @property close                    Close value.
 * @property volume                   Traded volume in the interval.
 * @property closeTime                Candlestick close timestamp in milliseconds.
 * @property quoteAssetVolume         Quote asset traded volume.
 * @property numberOfTrades           Number of trades.
 * @property takerBuyBaseAssetVolume  Taker buy base asset volume.
 * @property takerBuyQuoteAssetVolume Taker buy quote asset volume.
 */
@JsonDeserialize(using = CandleDeserializer::class)
@ApiModel("An ohlc candle for a symbol.")
data class Candle(
    @ApiModelProperty("The candlestick open timestamp in milliseconds.")
    var openTime: Long? = null,
    @ApiModelProperty("The Open value.")
    var open: String? = null,
    @ApiModelProperty("The High value.")
    var high: String? = null,
    @ApiModelProperty("The Low value.")
    var low: String? = null,
    @ApiModelProperty("The Close value.")
    var close: String? = null,
    @ApiModelProperty("The traded volume in the interval.")
    var volume: String? = null,
    @ApiModelProperty("The candlestick close timestamp in milliseconds.")
    var closeTime: Long? = null,
    @ApiModelProperty("The quote asset traded volume.")
    var quoteAssetVolume: String? = null,
    @ApiModelProperty("The number of trades.")
    var numberOfTrades: Long? = null,
    @ApiModelProperty("Taker buy base asset volume.")
    var takerBuyBaseAssetVolume: String? = null,
    @ApiModelProperty("Taker buy quote asset volume.")
    var takerBuyQuoteAssetVolume: String? = null
) {
    /**
     * accepting a list of String acting like a line of data in a csv file
     *
     * @property input String input.
     */
    constructor(input: List<String>) : this(
        input[0].toLong(), input[1], input[2], input[3], input[4], input[5], input[6].toLong(), input[7], input[8].toLong(), input[9], input[10]
    )
}
