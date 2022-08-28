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
 * A deposit history.
 *
 * @property amount        Volume to deposit.
 * @property coin          Coin abbreviation.
 * @property network       Transfer network.
 * @property address       Deposit address.
 * @property addressTag    Deposit address tag.
 * @property txId          Transaction id.
 * @property unlockConfirm confirm times for unlocking.
 * @property confirmTimes  Confirm times
 * @property status        Deposit status code.
 * @property insertTime    confirm times for insertion (?)
 * @property transferType  Transfer type. 1 for internal transfer, 0 for external transfer.
 * @property walletType    Wallet type. 0-spot wallet ，1-funding wallet.Default spot wallet.
 */
@ApiModel("A deposit history.")
data class DepositHistory(
    @ApiModelProperty("Volume to deposit.")
    var amount: String? = null,
    @ApiModelProperty("Coin abbreviation.")
    var coin: String? = null,
    @ApiModelProperty("Transfer network.")
    var network: String? = null,
    @ApiModelProperty("Deposit address.")
    var address: String? = null,
    @ApiModelProperty("Deposit address tag.")
    var addressTag: String? = null,
    @ApiModelProperty("Transaction id.")
    var txId: String? = null,
    @ApiModelProperty("confirm times for unlocking.")
    var unlockConfirm: String? = null,
    @ApiModelProperty("Confirm times")
    var confirmTimes: String? = null,
    @ApiModelProperty("Deposit status code.")
    var status: String? = null,
    @ApiModelProperty("confirm times for insertion (?)")
    var insertTime: Long? = null,
    @ApiModelProperty("Transfer type. 1 for internal transfer, 0 for external transfer.")
    var transferType: Int? = null,
    @ApiModelProperty("Wallet type. 0-spot wallet ，1-funding wallet.Default spot wallet.") var walletType: Int? = null
) {
    /** @return String value of status. */
    fun getDepositStatus(): DepositStatus {
        return DepositStatus.fromValue(status!!)!!
    }
}