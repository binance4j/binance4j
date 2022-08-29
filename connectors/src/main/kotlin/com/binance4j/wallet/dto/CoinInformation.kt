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
 * The coin info for the authenticated account.
 *
 * @property coin Coin abbreviation.
 * @property name Coin name.
 * @property depositAllEnable Deposit permission.
 * @property isLegalMoney Is the coin a legal money?
 * @property trading Can the coin be traded?
 * @property withdrawAllEnable Withdraw permission.
 * @property free Free balance.
 * @property freeze Frozen balance.
 * @property ipoable Initial Public Offering balance (?)
 * @property ipoing Initial Public Offering frozen balance (?)
 * @property locked Locked balance.
 * @property storage Storage
 * @property withdrawing Withdrawing balance.
 * @property networkList Coin network information.
 */
@ApiModel("The coin infos for the authenticated account.")
data class CoinInformation(
    @ApiModelProperty("Coin abbreviation.") @JsonProperty("coin") var coin: String = "",
    @ApiModelProperty("Coin name.") @JsonProperty("name") var name: String = "",
    @ApiModelProperty("Deposit permission.")
    @JsonProperty
    var depositAllEnable: Boolean = false,
    @ApiModelProperty("Is the coin a legal money?")
    @JsonProperty
    var isLegalMoney: Boolean = false,
    @ApiModelProperty("Can the coin be traded?") @JsonProperty("trading") var trading: Boolean = false,
    @ApiModelProperty("Withdraw permission.")
    @JsonProperty
    var withdrawAllEnable: Boolean = false,
    @ApiModelProperty("Free balance.") @JsonProperty("free") var free: String = "",
    @ApiModelProperty("Freezed balance.") @JsonProperty("freeze") var freeze: String = "",
    @ApiModelProperty("Initial Public Offering balance (?)")
    @JsonProperty
    var ipoable: String = "",
    @ApiModelProperty("Initial Public Offering freezed balance (?)")
    @JsonProperty
    var ipoing: String = "",
    @ApiModelProperty("Locked balance.") @JsonProperty("locked") var locked: String = "",
    @ApiModelProperty("Storage") @JsonProperty("storage") var storage: String = "",
    @ApiModelProperty("Withdrawing balance.") @JsonProperty("withdrawing") var withdrawing: String = "",
    @ApiModelProperty("Coin network information.")
    @JsonProperty
    var networkList:List<CoinNetworkInformation> = emptyList()
)
