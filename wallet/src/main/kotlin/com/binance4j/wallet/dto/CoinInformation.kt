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

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * The coin info for the authenticated account.
 *
 * @property coin              Coin abbreviation.
 * @property name              Coin name.
 * @property depositAllEnable  Deposit permission.
 * @property isLegalMoney      Is the coin a legal money?
 * @property trading           Can the coin be traded?
 * @property withdrawAllEnable Withdraw permission.
 * @property free              Free balance.
 * @property freeze            Frozen balance.
 * @property ipoable           Initial Public Offering balance (?)
 * @property ipoing            Initial Public Offering frozen balance (?)
 * @property locked            Locked balance.
 * @property storage           Storage
 * @property withdrawing       Withdrawing balance.
 * @property networkList       Coin network information.
 */
@ApiModel("The coin infos for the authenticated account.")
data class CoinInformation(
    @ApiModelProperty("Coin abbreviation.")
    var coin: String? = null,
    @ApiModelProperty("Coin name.")
    var name: String? = null,
    @ApiModelProperty("Deposit permission.")
    var depositAllEnable: Boolean? = null,
    @ApiModelProperty("Is the coin a legal money?")
    var isLegalMoney: Boolean? = null,
    @ApiModelProperty("Can the coin be traded?")
    var trading: Boolean? = null,
    @ApiModelProperty("Withdraw permission.")
    var withdrawAllEnable: Boolean? = null,
    @ApiModelProperty("Free balance.")
    var free: String? = null,
    @ApiModelProperty("Freezed balance.")
    var freeze: String? = null,
    @ApiModelProperty("Initial Public Offering balance (?)")
    var ipoable: String? = null,
    @ApiModelProperty("Initial Public Offering freezed balance (?)")
    var ipoing: String? = null,
    @ApiModelProperty("Locked balance.")
    var locked: String? = null,
    @ApiModelProperty("Storage")
    var storage: String? = null,
    @ApiModelProperty("Withdrawing balance.")
    var withdrawing: String? = null,
    @ApiModelProperty("Coin network information.")
    var networkList: List<CoinNetworkInformation>? = null
)
