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
 * Minimal info Ticker.
 *
 * @property eventType                   Event type.
 * @property eventTime                   Timestamp.
 * @property symbol                      Trading pair.
 * @property closePrice                  Close price.
 * @property openPrice                   Open price.
 * @property highPrice                   Highest price.
 * @property lowPrice                    Lowest price.
 * @property totalTradedBaseAssetVolume  Total traded base asset volume.
 * @property totalTradedQuoteAssetVolume Total traded quote asset volume.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Minimal info Ticker.")
data class MiniTicker(
    @ApiModelProperty("Event type.")
    @JsonProperty("e")
    var eventType: String? = null,

    @ApiModelProperty("Timestamp.")
    @JsonProperty("E")
    var eventTime: Long? = null,

    @ApiModelProperty("Trading pair.")
    @JsonProperty("s")
    var symbol: String? = null,

    @ApiModelProperty("Close price.")
    @JsonProperty("c")
    var closePrice: String? = null,

    @ApiModelProperty("Open price.")
    @JsonProperty("o")
    var openPrice: String? = null,

    @ApiModelProperty("Highest price.")
    @JsonProperty("h")
    var highPrice: String? = null,

    @ApiModelProperty("Lowest price.")
    @JsonProperty("l")
    var lowPrice: String? = null,

    @ApiModelProperty("Total traded base asset volume.")
    @JsonProperty("v")
    var totalTradedBaseAssetVolume: String? = null,

    @ApiModelProperty("Total traded quote asset volume.")
    @JsonProperty("q")
    var totalTradedQuoteAssetVolume: String? = null
) 