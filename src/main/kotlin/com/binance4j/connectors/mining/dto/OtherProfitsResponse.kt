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

import com.fasterxml.jackson.annotation.JsonProperty

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * {@link MiningClient} response.
 *
 * @property code Response code.
 * @property msg  Response message.
 * @property data Response data.
 */
@ApiModel("Other profits wrapper.")
data class OtherProfitsResponse(
    @ApiModelProperty("Response code.")
    @JsonProperty("code")
    var code: Int,
    @ApiModelProperty("Response message.")
    @JsonProperty("msg")
    var msg: String,
    @ApiModelProperty("Response data.")
    @JsonProperty("data")
    var data: OtherProfitsData?
) {
    /**
     * Other profits data.
     *
     * @property otherProfits Profits data.
     * @property totalNum     Total amount.
     * @property pageSize     Rows per page.
     */
    @ApiModel("Other profits data.")
    data class OtherProfitsData(
        @ApiModelProperty("Profits data.")
        @JsonProperty("otherProfits")
        var otherProfits: List<OtherProfit>?,
        @ApiModelProperty("Total amount.")
        @JsonProperty("totalNum")
        var totalNum: Long,
        @ApiModelProperty("Rows per page.")
        @JsonProperty("pageSize")
        var pageSize: Long
    ) {
        /**
         * Other profit.
         *
         * @property time         Mining date.
         * @property coinName     Coin Name.
         * @property profitAmount Amount.
         * @property status       Status. 0: Unpaid 1: Paying 2：Paid
         * @property type         Type. 1: Merged Mining 2: Activity Bonus 3: Rebate 4:Smart Pool 6: Income Transfer 7: PoolSavings
         */
        @ApiModel("Other profit.")
        data class OtherProfit(
            @ApiModelProperty("Mining date.")
            @JsonProperty("time")
            var time: Long,
            @ApiModelProperty("Coin Name.")
            @JsonProperty("coinName")
            var coinName: String,
            @ApiModelProperty("Amount.")
            @JsonProperty("type")
            var type: Int,
            @ApiModelProperty("Status. 0: Unpaid 1: Paying 2：Paid")
            @JsonProperty("profitAmount")
            var profitAmount: String,
            @ApiModelProperty("Type.1: Merged Mining 2: Activity Bonus 3: Rebate 4: Smart Pool 6: Income Transfer 7: Pool Savings")
            @JsonProperty("status")
            var status: Int
        )
    }
}