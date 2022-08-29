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
	@ApiModelProperty("Address pattern.") val addressRegex: String,
	@ApiModelProperty("Address rule") val addressRule: String,
	@ApiModelProperty("Coin abbreviation.") val coin: String,
	@ApiModelProperty("Deposit description.") val depositDesc: String,
	@ApiModelProperty("Withdraw description.") val withdrawDesc: String,
	@ApiModelProperty("Network name.") val name: String,
	@ApiModelProperty("Memo pattern.") val memoRegex: String,
	@ApiModelProperty("Network") val network: String,
	@ApiModelProperty("Tips about the network.") val specialTips: String,
	@ApiModelProperty("Tips about the withdraw.")
	@JsonProperty
	val specialWithdrawTips: String,
	@ApiModelProperty("Deposit dust.") val depositDust: String,
	@ApiModelProperty("Withdraw fee.") val withdrawFee: String,
	@ApiModelProperty("Withdraw integer multiple")
	@JsonProperty
	val withdrawIntegerMultiple: String,
	@ApiModelProperty("Maximal amount authorized to be withdrawn.")
	@JsonProperty
	val withdrawMax: String,
	@ApiModelProperty("Minimal amount authorized to be withdrawn.")
	@JsonProperty
	val withdrawMin: String,
	@ApiModelProperty("Min number for balance confirmation.")
	@JsonProperty
	val minConfirm: Int
	@ApiModelProperty("Confirmation number for balance unlock.")
@JsonProperty
val unLockConfirm: Int

@ApiModelProperty("If deposit is enabled.")
@JsonProperty
val depositEnable: Boolean,

@ApiModelProperty("if is the default network.")
@JsonProperty
val isDefault: Boolean,

@ApiModelProperty("Reset address status.")
@JsonProperty
val resetAddressStatus: Boolean,

@ApiModelProperty("If withdraw is enabled.")
@JsonProperty
val withdrawEnable: Boolean,

@ApiModelProperty("If the coin needs to provide memo to withdraw.")
@JsonProperty
val sameAddress: Boolean,

@ApiModelProperty("Estimated arrival time in ms.")
@JsonProperty
val estimatedArrivalTime: Long,
@ApiModelProperty("Is network busy?")
val busy: Boolean,
@ApiModelProperty("Country.")
val country: String
)
