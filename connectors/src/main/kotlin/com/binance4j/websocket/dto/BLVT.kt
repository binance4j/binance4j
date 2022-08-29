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
 * Net asset value.
 *
 * @property eventType    Event type.
 * @property eventTime    Event time.
 * @property name         Name.
 * @property tokensIssued Tokens issued.
 * @property baskets      BLVT basket.
 * @property nav          Nav.
 * @property realLeverage Real leverage.
 * @property leverage     Leverage.
 * @property fundingRatio Funding ratio.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("Net asset value.")
data class BLVT(
    @ApiModelProperty("Event type.")
    @JsonProperty("e")
    var eventType: String? = null,

    @ApiModelProperty("Event time.")
    @JsonProperty("E")
    var eventTime: Long? = null,

    @ApiModelProperty("Name.")
    @JsonProperty("s")
    var name: String? = null,

    @ApiModelProperty("Tokens issued.")
    @JsonProperty("m")
    var tokensIssued: String? = null,

    @ApiModelProperty("BVLT basket.")
    @JsonProperty("b")
    var baskets: List<BLVTBasket>? = null,

    @ApiModelProperty("Nav.")
    @JsonProperty("n")
    var nav: String? = null,

    @ApiModelProperty("Real leverage.")
    @JsonProperty("l")
    var realLeverage: String? = null,

    @ApiModelProperty("Leverage.")
    @JsonProperty("t")
    var leverage: Int? = null,

    @ApiModelProperty("Funding ratio.")
    @JsonProperty("f")
    var fundingRatio: String? = null
)