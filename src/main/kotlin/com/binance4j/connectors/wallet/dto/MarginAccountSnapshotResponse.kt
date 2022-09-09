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
 * Response of a MARGIN account snapshot request.
 *
 * @property code Code.
 * @property msg Message.
 * @property snapshotVos Snapshot.
 */
@ApiModel("Response of a MARGIN account snapshot request.")
data class MarginAccountSnapshotResponse(
    @JsonProperty("code")
    @ApiModelProperty("Code.")
    var code: Int,
    @ApiModelProperty("Message.")
    @JsonProperty("msg")
    var msg: String,
    @ApiModelProperty("Snapshot.")
    @JsonProperty("snapshotVos")
    var snapshotVos: List<Snapshot>
) {
    /**
     * A daily MARGIN account snapshot.
     *
     * @property type Type.
     * @property updateTime Update time in ms.
     * @property data Data.
     */
    @ApiModel("A daily MARGIN account snapshot.")
    data class Snapshot(
        @ApiModelProperty("Type.")
        @JsonProperty("type")
        var type: String,
        @ApiModelProperty("Update time in ms.")
        @JsonProperty("updateTime")
        var updateTime: Long,
        @ApiModelProperty("Data.")
        @JsonProperty("data")
        var data: Data?
    ) {

        /**
         * Margin account snapshot data.
         *
         * @property marginLevel Margin level.
         * @property totalAssetOfBtc Total Asset Of Btc.
         * @property totalLiabilityOfBtc Total Liability Of Btc.
         * @property totalNetAssetOfBtc Total Net Asset Of Btc.
         * @property userAssets User Assets.
         */
        @ApiModel("Margin account snapshot data.")
        data class Data(
            @ApiModelProperty("Margin level.")
            @JsonProperty("marginLevel")
            var marginLevel: String?,
            @ApiModelProperty("Total Asset Of Btc.")
            @JsonProperty("totalAssetOfBtc")
            var totalAssetOfBtc: String,
            @ApiModelProperty("Total Liability Of Btc.")
            @JsonProperty("totalLiabilityOfBtc")
            var totalLiabilityOfBtc: String,
            @ApiModelProperty("Total Net Asset Of Btc.")
            @JsonProperty("totalNetAssetOfBtc")
            var totalNetAssetOfBtc: String,
            @ApiModelProperty("User Assets.")
            @JsonProperty("userAssets")
            var userAssets: List<Assets>
        ) {

            /**
             * Margin account snapshot user assets.
             *
             * @property asset Asset abbreviation.
             * @property borrowed Borrowed amount.
             * @property free Fee amount.
             * @property interest Interest amount.
             * @property locked Locked volume.
             * @property netAsset Net asset.
             */
            @ApiModel("Margin account snapshot user assets.")
            data class Assets(
                @ApiModelProperty("Asset abbreviation.")
                @JsonProperty("asset")
                var asset: String,
                @ApiModelProperty("Borrowed amount.")
                @JsonProperty("borrowed")
                var borrowed: String,
                @ApiModelProperty("Fee amount.")
                @JsonProperty("free")
                var free: String,
                @ApiModelProperty("Interest amount.")
                @JsonProperty("interest")
                var interest: String,
                @ApiModelProperty("Locked volume.")
                @JsonProperty("locked")
                var locked: String,
                @ApiModelProperty("Net asset.")
                @JsonProperty("netAsset")
                var netAsset: String
            )
        }
    }

}
