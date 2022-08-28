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

package com.binance4j.fiat.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * A fiat payment.
 *
 * @property orderNo Order No.
 * @property sourceAmount Fiat trade amount.
 * @property fiatCurrency Fiat token.
 * @property obtainAmount Crypto trade amount.
 * @property cryptoCurrency Crypto token.
 * @property totalFee Trade fee.
 * @property price Price.
 * @property status Status: {@code Processing}, {@code Completed}, {@code Failed}, {@code Refunded}.
 * @property createTime Create time in ms.
 * @property updateTime Update time in ms.
 */
@ApiModel("A fiat payment.")
data class Payment(
        @ApiModelProperty("Order No.") @JsonProperty("orderNo") var orderNo: String? = null,
        @ApiModelProperty("Fiat trade amount.") @JsonProperty("sourceAmount") var sourceAmount: String? = null,
        @ApiModelProperty("Fiat token.") @JsonProperty("fiatCurrency") var fiatCurrency: String? = null,
        @ApiModelProperty("Crypto trade amount.") @JsonProperty("obtainAmount") var obtainAmount: String? = null,
        @ApiModelProperty("Crypto token.") @JsonProperty("cryptoCurrency") var cryptoCurrency: String? = null,
        @ApiModelProperty("Trade fee.") @JsonProperty("totalFee") var totalFee: String? = null,
        @ApiModelProperty("Price.") @JsonProperty("price") var price: String? = null,
        @ApiModelProperty("Status: Processing, Completed, Failed, Refunded.")
        @JsonProperty
        var status: String? = null,
        @ApiModelProperty("Create time in ms.") @JsonProperty("createTime") var createTime: Long? = null,
        @ApiModelProperty("Update time in ms.") @JsonProperty("updateTime") var updateTime: Long? = null
)
