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

import com.fasterxml.jackson.annotation.JsonIncludeProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * An executed trade.
 *
 * @property id Trade id.
 * @property price Price.
 * @property qty Quantity.
 * @property quoteQty Quote quantity for the trade (price * qty).
 * @property commission Commission.
 * @property commissionAsset Asset on which commission is taken.
 * @property time Trade execution time.
 * @property symbol Symbol of the trade.
 * @property orderId Order id.
 * @property orderListId Order list id.
 * @property isBuyer Is buyer trade.
 * @property isMaker Is maker trade.
 * @property isBestMatch Is best match?
 */
@ApiModel("An executed trade.")
@JsonIncludeProperties
data class Trade(
        @ApiModelProperty("Trade id.")
        @JsonProperty("id")
        var id: Long = 0L,

        @ApiModelProperty("Price.")
        @JsonProperty("price")
        var price: String = "",

        @ApiModelProperty("Quantity.")
        @JsonProperty("qty")
        var qty: String = "",

        @ApiModelProperty("Quote quantity for the trade (price * qty).")
        @JsonProperty
        var quoteQty: String = "",

        @ApiModelProperty("Commission.")
        @JsonProperty("commission")
        var commission: String = "",

        @ApiModelProperty("Asset on which commission is taken.")
        @JsonProperty
        var commissionAsset: String = "",

        @ApiModelProperty("Trade execution time.")
        @JsonProperty("time")
        var time: Long = 0L,

        @ApiModelProperty("The symbol of the trade.")
        @JsonProperty("symbol")
        var symbol: String = "",

        @ApiModelProperty("The order id.")
        @JsonProperty("orderId")
        var orderId: String = "",

        @ApiModelProperty("The order list id.")
        @JsonProperty("orderListId")
        var orderListId: String = "",

        @ApiModelProperty("Is buyer trade.")
        @JsonProperty("isBuyer")
        var isBuyer: Boolean = false,

        @ApiModelProperty("Is maker trade.")
        @JsonProperty("isMaker")
        var isMaker: Boolean = false,

        @ApiModelProperty("Is best match?")
        @JsonProperty("isBestMatch")
        var isBestMatch: Boolean = false
)
