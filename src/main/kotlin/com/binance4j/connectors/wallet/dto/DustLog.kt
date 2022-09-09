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
 * Logs of assets converted in BNB.
 *
 * @property total Total counts of exchange.
 * @property userAssetDribblets Dribblets.
 */
@ApiModel("Logs of assets converted in BNB.")
data class DustLog(
    @ApiModelProperty("Total counts of exchange.")
    @JsonProperty("total")
    var total: Int,
    @ApiModelProperty("Dribblets.")
    @JsonProperty("userAssetDribblets")
    var userAssetDribblets: List<UserAssetDribblets>
) {
    /**
     * Dribblets.
     *
     * @property operateTime Operation timestamp.
     * @property totalTransferedAmount Total transfered BNB amount for this
     * ```
     *                                 exchange.
     * @property totalServiceChargeAmount
     * ```
     * Total service charge amount for this
     * ```
     *                                 exchange.
     * @property transId
     * ```
     * Transaction id.
     * @property userAssetDribbletDetails Details of this exchange.
     */
    @ApiModel("Dribblets.")
    data class UserAssetDribblets(
        @ApiModelProperty("Operation timestamp.")
        @JsonProperty("operateTime")
        var operateTime: Long,
        @ApiModelProperty("Total transfered BNB amount for this exchange.")
        @JsonProperty("totalTransferedAmount")
        var totalTransferedAmount: String,
        @ApiModelProperty("Total service charge amount for this exchange.")
        @JsonProperty("totalServiceChargeAmount")
        var totalServiceChargeAmount: String,
        @ApiModelProperty("Transaction id.")
        @JsonProperty("transId")
        var transId: Long,
        @ApiModelProperty("Details of this exchange.")
        @JsonProperty("userAssetDribbletDetails")
        var userAssetDribbletDetails: List<UserAssetDribbletDetails>
    ) {
        /**
         * Dust log details.
         *
         * @property transId Transaction id.
         * @property operateTime Timestamp.
         * @property serviceChargeAmount Fees.
         * @property amount Volume.
         * @property transferedAmount Transferred amount.
         * @property fromAsset Transferred asset.
         */
        @ApiModel("Dust log details.")
        data class UserAssetDribbletDetails(
            @ApiModelProperty("Transaction id.")
            @JsonProperty("transId")
            var transId: Long,
            @ApiModelProperty("Timestamp.")
            @JsonProperty("operateTime")
            var operateTime: Long,
            @ApiModelProperty("Fees.")
            @JsonProperty("serviceChargeAmount")
            var serviceChargeAmount: String,
            @ApiModelProperty("Volume.")
            @JsonProperty("amount")
            var amount: String,
            @ApiModelProperty("Transferred amount.")
            @JsonProperty("transferedAmount")
            var transferedAmount: String,
            @ApiModelProperty("Transferred asset.")
            @JsonProperty("fromAsset")
            var fromAsset: String
        )
    }
}
