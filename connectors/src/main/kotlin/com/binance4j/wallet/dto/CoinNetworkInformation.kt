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

package com.binance4j.wallet.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * The coin network information.
 *
 * @property addressRegex Address pattern.
 * @property addressRule Address rule
 * @property coin Coin abbreviation.
 * @property depositDesc Deposit description.
 * @property withdrawDesc Withdraw description.
 * @property name Network name.
 * @property memoRegex Memo pattern.
 * @property network Network
 * @property specialTips Tips about the network.
 * @property specialWithdrawTips Tips about the withdrawal.
 * @property depositDust Deposit dust.
 * @property withdrawFee Withdraw fee.
 * @property withdrawIntegerMultiple Withdraw integer multiple
 * @property withdrawMax Maximal amount authorized to be withdrawn.
 * @property withdrawMin Minimal amount authorized to be withdrawn.
 * @property minConfirm Min number for balance confirmation.
 * @property unLockConfirm Confirmation number for balance unlock.
 * @property depositEnable If deposit is enabled.
 * @property isDefault if is the default network.
 * @property resetAddressStatus Reset address status.
 * @property withdrawEnable If withdraw is enabled.
 * @property sameAddress If the coin needs to provide memo to withdraw.
 * @property estimatedArrivalTime Estimated arrival time in ms.
 * @property busy Is network busy?
 * @property country Country.
 */
@ApiModel("The coin network information.")
data class CoinNetworkInformation(
    @ApiModelProperty("Address pattern.") @JsonProperty("addressRegex") var addressRegex: String? = null,
    @ApiModelProperty("Address rule") @JsonProperty("addressRule") var addressRule: String? = null,
    @ApiModelProperty("Coin abbreviation.") @JsonProperty("coin") var coin: String? = null,
    @ApiModelProperty("Deposit description.") @JsonProperty("depositDesc") var depositDesc: String? = null,
    @ApiModelProperty("Withdraw description.") @JsonProperty("withdrawDesc") var withdrawDesc: String? = null,
    @ApiModelProperty("Network name.") @JsonProperty("name") var name: String? = null,
    @ApiModelProperty("Memo pattern.") @JsonProperty("memoRegex") var memoRegex: String? = null,
    @ApiModelProperty("Network") @JsonProperty("network") var network: String? = null,
    @ApiModelProperty("Tips about the network.") @JsonProperty("specialTips") var specialTips: String? = null,
    @ApiModelProperty("Tips about the withdraw.")
    @JsonProperty
    var specialWithdrawTips: String? = null,
    @ApiModelProperty("Deposit dust.") @JsonProperty("depositDust") var depositDust: String? = null,
    @ApiModelProperty("Withdraw fee.") @JsonProperty("withdrawFee") var withdrawFee: String? = null,
    @ApiModelProperty("Withdraw integer multiple")
    @JsonProperty
    var withdrawIntegerMultiple: String? = null,
    @ApiModelProperty("Maximal amount authorized to be withdrawn.")
    @JsonProperty
    var withdrawMax: String? = null,
    @ApiModelProperty("Minimal amount authorized to be withdrawn.")
    @JsonProperty
    var withdrawMin: String? = null,
    @ApiModelProperty("Min number for balance confirmation.")
    @JsonProperty
    var minConfirm: Int? = null,
    @ApiModelProperty("Confirmation number for balance unlock.")
    @JsonProperty
    var unLockConfirm: Int? = null,
    @ApiModelProperty("If deposit is enabled.")
    @JsonProperty
    var depositEnable: Boolean? = null,
    @ApiModelProperty("if is the default network.")
    @JsonProperty
    var isDefault: Boolean? = null,
    @ApiModelProperty("Reset address status.")
    @JsonProperty
    var resetAddressStatus: Boolean? = null,
    @ApiModelProperty("If withdraw is enabled.")
    @JsonProperty
    var withdrawEnable: Boolean? = null,
    @ApiModelProperty("If the coin needs to provide memo to withdraw.")
    @JsonProperty
    var sameAddress: Boolean? = null,
    @ApiModelProperty("Estimated arrival time in ms.")
    @JsonProperty
    var estimatedArrivalTime: Long? = null,
    @ApiModelProperty("Is network busy?") @JsonProperty("busy") var busy: Boolean? = null,
    @ApiModelProperty("Country.") @JsonProperty("country") var country: String? = null
)
