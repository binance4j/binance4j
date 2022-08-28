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

package com.binance4j.c2c.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * A C2C Trade.
 *
 * @property orderNumber Order number.
 * @property advNo Adv No.
 * @property tradeType Trade type.
 * @property asset Asset.
 * @property fiat Fiat.
 * @property fiatSymbol Fiat symbol.
 * @property amount Amount.
 * @property totalPrice Total price.
 * @property unitPrice Unit price.
 * @property orderStatus Order status.
 * @property createTime Create time.
 * @property commission Commission.
 * @property counterPartNickName Counterpart nickname.
 * @property advertisementRole Advertisement role.
 */
@ApiModel("A C2C Trade.")
data class Trade(
        @ApiModelProperty("Order number.")
        @JsonProperty("orderNumber")
        var orderNumber: String? = null,

        @ApiModelProperty("Adv No.")
        @JsonProperty("advNo")
        var advNo: Long? = null,

        @ApiModelProperty("Trade type.")
        @JsonProperty("tradeType")
        var tradeType: String? = null,

        @ApiModelProperty("Asset.")
        @JsonProperty("asset")
        var asset: String? = null,

        @ApiModelProperty("Fiat.")
        @JsonProperty("fiat")
        var fiat: String? = null,

        @ApiModelProperty("Fiat symbol.")
        @JsonProperty("fiatSymbol")
        var fiatSymbol: String? = null,

        @ApiModelProperty("Amount.")
        @JsonProperty("amount")
        var amount: String? = null,

        @ApiModelProperty("Total price.")
        @JsonProperty("totalPrice")
        var totalPrice: String? = null,

        @ApiModelProperty("Unit price.")
        @JsonProperty("unitPrice")
        var unitPrice: String? = null,

        @ApiModelProperty("Order status.")
        @JsonProperty("orderStatus")
        var orderStatus: String? = null,

        @ApiModelProperty("Create time.")
        @JsonProperty("createTime")
        var createTime: Long? = null,

        @ApiModelProperty("Commission.")
        @JsonProperty("commission")
        var commission: String? = null,

        @ApiModelProperty("Counter part nickname.")
        @JsonProperty("counterPartNickName")
        var counterPartNickName: String? = null,

        @ApiModelProperty("Advertisement role.")
        @JsonProperty("advertisementRole")
        var advertisementRole: String? = null
)
