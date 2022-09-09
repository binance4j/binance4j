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

package com.binance4j.connectors.wallet.dto

import com.fasterxml.jackson.annotation.JsonProperty

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Response of a FUTURES account snapshot request.
 *
 * @property code Code.
 * @property msg Message.
 * @property snapshotVos Snapshot.
 */
@ApiModel("Response of a FUTURES account snapshot request.")
data class FuturesAccountSnapshot(
    @ApiModelProperty("Code.")
    @JsonProperty("code")
    var code: Int,
    @ApiModelProperty("Message.")
    @JsonProperty("msg")
    var msg: String,
    @ApiModelProperty("Snapshot.")
    @JsonProperty("snapshotVos")
    var snapshotVos: List<Snapshot>
) {
    /**
     * A daily FUTURES account snapshot.
     *
     * @property type Type.
     * @property updateTime Update time in ms.
     * @property data Data.
     */
    @ApiModel("A daily FUTURES account snapshot.")
    data class Snapshot(
        @JsonProperty("type")
        @ApiModelProperty("Type.")
        var type: String,
        @JsonProperty("updateTime")
        @ApiModelProperty("Update time in ms.")
        var updateTime: Long,
        @ApiModelProperty("Data.")
        @JsonProperty("data")
        var data: Data
    ) {
        /**
         * The account snapshot data.
         *
         * @property assets Assets balances.
         * @property position Account snapshot position.
         */
        @ApiModel("The account snapshot data.")
        data class Data(
            @ApiModelProperty("Assets balances.")
            @JsonProperty("assets")
            var assets: List<Assets>,
            @ApiModelProperty("Account snapshot position.")
            @JsonProperty("position")
            var position: List<Position>
        ) {
            /**
             * The snapshot assets balances.
             *
             * @property asset Asset abbreviation.
             * @property marginBalance Margin balance.
             * @property walletBalance Wallet balance.
             */
            @ApiModel("The snapshot assets balances.")
            data class Assets(
                @ApiModelProperty("Asset abbreviation.")
                @JsonProperty("asset")
                var asset: String,
                @ApiModelProperty("Margin balance.")
                @JsonProperty("marginBalance")
                var marginBalance: String,
                @ApiModelProperty("Wallet balance.")
                @JsonProperty("walletBalance")
                var walletBalance: String
            )

            /**
             * Futures account snapshot position.
             *
             * @property symbol Symbol.
             * @property entryPrice Entry price.
             * @property markPrice Mark price.
             * @property positionAmt Position amount.
             * @property unRealizedProfit Unrealized profit.
             */
            @ApiModel("Futures account snapshot position.")
            data class Position(
                @ApiModelProperty("Symbol.")
                @JsonProperty("symbol")
                var symbol: String,
                @ApiModelProperty("Entry price.")
                @JsonProperty("entryPrice")
                var entryPrice: String,
                @ApiModelProperty("Mark price.")
                @JsonProperty("markPrice")
                var markPrice: String,
                @ApiModelProperty("Position amount.")
                @JsonProperty("positionAmt")
                var positionAmt: String,
                @ApiModelProperty("Unrealized profit.")
                @JsonProperty("unRealizedProfit")
                var unRealizedProfit: String
            )
        }
    }
}
