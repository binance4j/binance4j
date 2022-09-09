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

import com.binance4j.connectors.core.dto.AssetBalance
import com.fasterxml.jackson.annotation.JsonProperty

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Response of a SPOT account snapshot request.
 *
 * @property code Code.
 * @property msg Message.
 * @property snapshotVos Snapshot.
 */
@ApiModel("Response of a SPOT account snapshot request.")
data class SpotAccountSnapshotResponse(
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
     * A daily SPOT account snapshot.
     *
     * @property type Type.
     * @property updateTime Update time in ms.
     * @property data Data.
     */
    @ApiModel("A daily SPOT account snapshot.")
    data class Snapshot(
        @ApiModelProperty("Type.")
        @JsonProperty("type")
        var type: String,
        @ApiModelProperty("Update time in ms.")
        @JsonProperty("updateTime")
        var updateTime: Long,
        @ApiModelProperty("Data.")
        @JsonProperty("data")
        var data: Data
    ) {
        /**
         * The SPOT account snapshot data.
         *
         * @property balances Wallet asset balances.
         * @property totalAssetOfBtc Cumulated value of the wallet in Bitcoin.
         */
        @ApiModel("The SPOT account snapshot data.")
        data class Data(
            @ApiModelProperty("Wallet asset balances.")
            @JsonProperty("balances")
            var balances: List<AssetBalance>,
            @ApiModelProperty("Cumulated value of the wallet in Bitcoin.")
            @JsonProperty("totalAssetOfBtc")
            var totalAssetOfBtc: String
        )
    }
}