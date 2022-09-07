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

package com.binance4j.connectors.pay.dto

import com.fasterxml.jackson.annotation.JsonProperty

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Pay trade history.
 *
 * @property code    Response code.
 * @property message Response message.
 * @property data    Trades.
 * @property success Response success.
 */
@ApiModel("Pay trade history.")
data class TradeHistory(
    @ApiModelProperty("Response code.")
    @JsonProperty("code")
    var code: String,
    @ApiModelProperty("Response message.")
    @JsonProperty("message")
    var message: String,
    @ApiModelProperty("Trades.")
    @JsonProperty("data")
    var data: List<Trade>,
    @ApiModelProperty("Response success.")
    @JsonProperty("success")
    var success: Boolean
) {
    /**
     * Pay transaction.
     *
     * @property transactionId   Transaction id.
     * @property transactionTime Transaction time in ms.
     * @property amount          Transaction amount.
     * @property currency        Transaction asset.
     * @property fundsDetail     Funds details.
     * @property orderType       Order type.
     * @see OrderType
     */
    @ApiModel("Pay transaction.")
    data class Trade(
        @ApiModelProperty("Transaction id.")
        @JsonProperty("orderType")
        var orderType: String,
        @ApiModelProperty("Transaction time in ms.")
        @JsonProperty("transactionId")
        var transactionId: String,
        @ApiModelProperty("Transaction amount.")
        @JsonProperty("transactionTime")
        var transactionTime: Long,
        @ApiModelProperty("Transaction asset.")
        @JsonProperty("amount")
        var amount: String,
        @ApiModelProperty("Funds details.")
        @JsonProperty("currency")
        var currency: String,
        @ApiModelProperty("Order type. PAY: C2B Merchant Acquiring Payment. PAY_REFUND: C2B Merchant Acquiring Payment,refund. C2C: C2C Transfer Payment. CRYPTO_BOX: Crypto box. CRYPTO_BOX_RF: Crypto Box, refund. C2C_HOLDING: Transfer to new Binance user. C2C_HOLDING_RF: Transfer to new Binance user,refund. PAYOUT: B2C Disbursement Payment. ")
        @JsonProperty("fundsDetail")
        var fundsDetail: List<FundsDetail>
    ) {
        /**
         * Funds detail.
         *
         * @property currency Asset.
         * @property amount   Amount.
         */
        @ApiModel("Funds detail.")
        data class FundsDetail(
            @ApiModelProperty("Asset.")
            @JsonProperty("currency")
            var currency: String,
            @ApiModelProperty("Amount.")
            @JsonProperty("amount")
            var amount: String
        )
    }
}
