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
 * An order report.
 *
 * @property orderListId Order list id.
 * @property origClientOrderId Original client order id.
 * @property transactTime Order timestamp.
 * @property side Order side.
 * @property price Price.
 * @property origQty Original quantity.
 * @property executedQty Original quantity.
 * @property cumulativeQuoteQty Used to calculate the average price.
 * @property status Order status.
 * @property timeInForce Time in force to indicate how long will the order remain active.
 * @property type Type of order.
 * @property stopPrice Used with stop orders.
 * @property icebergQty Used with iceberg orders.
 * @property time Order timestamp.
 * @property updateTime Update timestamp.
 * @property origQuoteOrderQty Original quote order quantity.
 * @property isWorking Is working.
 * @property isIsolated is isolated margin.
 * @property symbol Order symbol.
 * @property orderId Order id.
 * @property clientOrderId Client order id.
 */
@ApiModel("An order report.")
data class OrderReport(
    @ApiModelProperty("The order list id.")
    @JsonProperty("orderListId")
    var orderListId: Long? = null,

    @ApiModelProperty("The original client order id.")
    @JsonProperty("origClientOrderId")
    var origClientOrderId: String? = null,

    @ApiModelProperty("The order timestamp.")
    @JsonProperty("transactTime")
    var transactTime: Long? = null,

    @ApiModelProperty("The order side.")
    @JsonProperty("side")
    var side: OrderSide? = null,

    @ApiModelProperty("Price.")
    @JsonProperty("price")
    var price: String? = null,

    @ApiModelProperty("Original quantity.")
    @JsonProperty("origQty")
    var origQty: String? = null,

    @ApiModelProperty("Original quantity.")
    @JsonProperty("executedQty")
    var executedQty: String? = null,

    @ApiModelProperty("Used to calculate the average price.")
    @JsonProperty("cummulativeQuoteQty")
    var cumulativeQuoteQty: String? = null,

    @ApiModelProperty("Order status.")
    @JsonProperty("status")
    var status: String? = null,

    @ApiModelProperty("Time in force to indicate how long will the order remain active.")
    @JsonProperty("timeInForce")
    var timeInForce: String? = null,

    @ApiModelProperty("Type of order.")
    @JsonProperty("type")
    var type: String? = null,

    @ApiModelProperty("Used with stop orders.")
    @JsonProperty("stopPrice")
    var stopPrice: String? = null,

    @ApiModelProperty("Used with iceberg orders.")
    @JsonProperty("icebergQty")
    var icebergQty: String? = null,

    @ApiModelProperty("Order timestamp.")
    @JsonProperty("time")
    var time: Long? = null,

    @ApiModelProperty("Update timestamp.")
    @JsonProperty("updateTime")
    var updateTime: Long? = null,

    @ApiModelProperty("Original quote order quantity.")
    @JsonProperty("origQuoteOrderQty")
    var origQuoteOrderQty: String? = null,

    @ApiModelProperty("Is working.")
    @JsonProperty("isWorking")
    var isWorking: Boolean? = null,

    @ApiModelProperty("is isolated margin.")
    @JsonProperty("isIsolated")
    var isIsolated: Boolean? = null,

    @ApiModelProperty("The order symbol.")
    @JsonProperty("symbol")
    var symbol: String? = null,

    @ApiModelProperty("Order id.")
    @JsonProperty("orderId")
    var orderId: Long? = null,

    @ApiModelProperty("Client order id.")
    @JsonProperty("clientOrderId")
    var clientOrderId: String? = null
)
