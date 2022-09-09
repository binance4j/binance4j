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
 * Assets that can be converted into BNB.
 *
 * @property details Details.
 * @property totalTransferBtc BTC valuation.
 * @property totalTransferBNB BNB valuation.
 * @property dribbletPercentage Commission fee.
 */
@ApiModel("Assets that can be converted into BNB.")
data class ConvertibleAssets(
    @ApiModelProperty("Details.")
    @JsonProperty("details")
    var details: List<ConvertibleAsset>,
    @ApiModelProperty("BTC valuation.")
    @JsonProperty("totalTransferBtc")
    var totalTransferBtc: String,
    @ApiModelProperty("BNB valuation.")
    @JsonProperty("totalTransferBNB")
    var totalTransferBNB: String,
    @ApiModelProperty("Commission fee.")
    @JsonProperty("dribbletPercentage")
    var dribbletPercentage: String
) {
    /**
     * Asset that can be converted into BNB.
     *
     * @property asset Asset name.
     * @property assetFullName Asset full name.
     * @property amountFree Free balance.
     * @property toBTC BTC valuation.
     * @property toBNB BNB valuation.
     * @property toBNBOffExchange BNB valuation commissions fees deducted.
     * @property exchange Commission fees.
     */
    @ApiModel("Asset that can be converted into BNB.")
    data class ConvertibleAsset(
        @ApiModelProperty("Asset name.")
        @JsonProperty("asset")
        var asset: String,
        @ApiModelProperty("Asset full name.")
        @JsonProperty("assetFullName")
        var assetFullName: String,
        @ApiModelProperty("Free balance.")
        @JsonProperty("amountFree")
        var amountFree: String,
        @ApiModelProperty("BTC valuation.")
        @JsonProperty("toBTC")
        var toBTC: String,
        @ApiModelProperty("BNB valuation.")
        @JsonProperty("toBNB")
        var toBNB: String,
        @ApiModelProperty("BNB valuation commissions fees deducted.")
        @JsonProperty("toBNBOffExchange")
        var toBNBOffExchange: String,
        @ApiModelProperty("Commission fees.")
        @JsonProperty("exchange")
        var exchange: String
    )
}
