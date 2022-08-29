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

package com.binance4j.convert.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * A conversion of an asset into another.
 *
 * @property quoteId Quote Id.
 * @property orderId Order Id.
 * @property orderStatus Order Status.
 * @property fromAsset From Asset.
 * @property fromAmount From Amount.
 * @property toAsset To Asset.
 * @property toAmount To Amount.
 * @property ratio Ratio.
 * @property inverseRatio Inverse Ratio.
 * @property createTime Create Time in ms.
 */
@ApiModel("A conversion of an asset into another.")
data class Conversion(
    @ApiModelProperty("Quote Id.")
    @JsonProperty("quoteId")
    var quoteId: String = "",

    @ApiModelProperty("Order Id.")
    @JsonProperty("orderId")
    var orderId: Long = 0L,

    @ApiModelProperty("Order Status.")
    @JsonProperty("orderStatus")
    var orderStatus: String = "",

    @ApiModelProperty("From Asset.")
    @JsonProperty("fromAsset")
    var fromAsset: String = "",

    @ApiModelProperty("From Amount.")
    @JsonProperty("fromAmount")
    var fromAmount: String = "",

    @ApiModelProperty("To Asset.")
    @JsonProperty("toAsset")
    var toAsset: String = "",

    @ApiModelProperty("To Amount.")
    @JsonProperty("toAmount")
    var toAmount: String = "",

    @ApiModelProperty("Ratio.")
    @JsonProperty("ratio")
    var ratio: String = "",

    @ApiModelProperty("Inverse Ratio.")
    @JsonProperty("inverseRatio")
    var inverseRatio: String = "",

    @ApiModelProperty("Create Time in ms.")
    @JsonProperty("createTime")
    var createTime: Long = 0L
)