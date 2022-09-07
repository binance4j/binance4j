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

package com.binance4j.connectors.mining.dto

import com.binance4j.connectors.mining.client.MiningClient
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * [MiningClient.getAccountProfits] response.
 *
 * @property code Response code.
 * @property msg  Response message.
 * @property data Response data.
 */
@ApiModel("Account profits wrapper.")
data class AccountProfitsResponse(
    @ApiModelProperty("Response code.")
    @JsonProperty("code")
    var code: Int,
    @ApiModelProperty("Response message.")
    @JsonProperty("msg")
    var msg: String,
    @ApiModelProperty("Response data.")
    @JsonProperty("data")
    var data: AccountProfitsData?
) {
    /**
     * Account profits data.
     *
     * @property accountProfits Profits data.
     * @property totalNum       Total amount.
     * @property pageSize       Rows per page.
     */
    @ApiModel("Account profits data.")
    data class AccountProfitsData(
        @ApiModelProperty("Profits data.")
        @JsonProperty("accountProfits")
        var accountProfits: List<AccountProfit>?,
        @ApiModelProperty("Total amount.")
        @JsonProperty("totalNum")
        var totalNum: Long = 0L,
        @ApiModelProperty("Rows per page.")
        @JsonProperty("pageSize")
        var pageSize: Long = 0L
    ) {
        /**
         * Account profit.
         *
         * @property time     Time in ms.
         * @property coinName Coin.
         * @property type     0:Referral 1：Refund 2：Rebate.
         * @property puid     Sub-account id.
         * @property subName  Mining account.
         * @property amount   Amount.
         */
        @ApiModel("Account profit.")
        data class AccountProfit(
            @ApiModelProperty("Time in ms.")
            @JsonProperty("time")
            var time: Long,
            @ApiModelProperty("Coin.")
            @JsonProperty("coinName")
            var coinName: String,
            @ApiModelProperty("0:Referral 1：Refund 2：Rebate.")
            @JsonProperty("type")
            var type: Int,
            @ApiModelProperty("Sub-account id.")
            @JsonProperty("puid")
            var puid: Int,
            @ApiModelProperty("Mining account.")
            @JsonProperty("subName")
            var subName: String,
            @ApiModelProperty("Amount.")
            @JsonProperty("amount")
            var amount: String
        )
    }
}