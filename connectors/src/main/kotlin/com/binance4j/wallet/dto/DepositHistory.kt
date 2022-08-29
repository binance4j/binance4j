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
 * A deposit history.
 *
 * @property amount Volume to deposit.
 * @property coin Coin abbreviation.
 * @property network Transfer network.
 * @property address Deposit address.
 * @property addressTag Deposit address tag.
 * @property txId Transaction id.
 * @property unlockConfirm confirm times for unlocking.
 * @property confirmTimes Confirm times
 * @property status Deposit status code.
 * @property insertTime confirm times for insertion (?)
 * @property transferType Transfer type. 1 for internal transfer, 0 for external transfer.
 * @property walletType Wallet type. 0-spot wallet ，1-funding wallet.Default spot wallet.
 */
@ApiModel("A deposit history.")
data class DepositHistory(
    @ApiModelProperty("Volume to deposit.") @JsonProperty("amount") var amount: String = "",
    @ApiModelProperty("Coin abbreviation.") @JsonProperty("coin") var coin: String = "",
    @ApiModelProperty("Transfer network.") @JsonProperty("network") var network: String = "",
    @ApiModelProperty("Deposit address.") @JsonProperty("address") var address: String = "",
    @ApiModelProperty("Deposit address tag.") @JsonProperty("addressTag") var addressTag: String = "",
    @ApiModelProperty("Transaction id.") @JsonProperty("txId") var txId: String = "",
    @ApiModelProperty("confirm times for unlocking.")
    @JsonProperty
    var unlockConfirm: String = "",
    @ApiModelProperty("Confirm times") @JsonProperty("confirmTimes") var confirmTimes: String = "",
    @ApiModelProperty("Deposit status code.") @JsonProperty("status") var status: String = "",
    @ApiModelProperty("confirm times for insertion (?)")
    @JsonProperty
    var insertTime: Long = 0L,
    @ApiModelProperty("Transfer type. 1 for internal transfer, 0 for external transfer.")
    @JsonProperty
    var transferType: Int = 0,
    @ApiModelProperty("Wallet type. 0-spot wallet ，1-funding wallet.Default spot wallet.")
    @JsonProperty
    var walletType: Int = 0
) {
    /** @return String value of status. */
    fun getDepositStatus(): DepositStatus {
        return DepositStatus.fromValue(status!!)!!
    }
}
