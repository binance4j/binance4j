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

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Aggregated trades.
 * @property tradeId The trade id.
 * @property price The price.
 * @property quantity The quantity.
 * @property firstTradeId The first trade id.
 * @property lastTradeId The last trade id.
 * @property time The timestamp.
 * @property isBuyerMaker Was it a buyer maker.
 * @property isBestMatch Was it the best price match.
 */
@ApiModel(description = "Aggregated trades.")
data class AggTrade
constructor(
    @JsonProperty("a")
    @ApiModelProperty("The trade id")
    var tradeId: Long = 0L,

    @JsonProperty("p") @ApiModelProperty("The price") var price: String = "",

    @JsonProperty("q")
    @ApiModelProperty("The quantity")
    var quantity: String = "",

    @JsonProperty("f")
    @ApiModelProperty("The first trade id")
    var firstTradeId: Long = 0L,

    @JsonProperty("l")
    @ApiModelProperty("The last trade id")
    var lastTradeId: Long = 0L,

    @JsonProperty("T") @ApiModelProperty("The timestamp") var time: Long = 0L,

    @JsonProperty("m")
    @ApiModelProperty("Was it a buyer maker")
    var isBuyerMaker: Boolean = false,
    
    @JsonProperty("M")
    @ApiModelProperty("Was it the best price match?")
    var isBestMatch: Boolean = false
) {

    /** @property input CSV line. */
    constructor(
        input: List<String>
    ) : this(
        input[0].toLong(),
        input[1],
        input[2],
        input[3].toLong(),
        input[4].toLong(),
        input[5].toLong(),
        java.lang.Boolean.parseBoolean(input[6]),
        java.lang.Boolean.parseBoolean(input[7])
    )
}
