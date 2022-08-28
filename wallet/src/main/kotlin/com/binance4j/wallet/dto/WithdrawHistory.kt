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
 * The withdrawal history.
 *
 * @property address Address to withdraw to.
 * @property applyTime Withdraw date operation.
 * @property coin Coin to withdraw.
 * @property id Withdraw id.
 * @property withdrawOrderId Withdraw order id. will not be returned if there's no withdrawOrderId
 * for this withdraw.
 * @property network Network to withdraw on.
 * @property info Reason for withdrawal failure.
 * @property txId Transaction id.
 * @property txKey Transaction key.
 * @property transferType 1 for internal transfer, 0 for external transfer.
 * @property status (0:Email Sent, 1:Cancelled 2:Awaiting Approval 3:Rejected 4:Processing 5:Failure
 * 6:Completed)
 * @property confirmNo Confirm times for withdraw.
 * @property amount Withdrawn column.
 * @property transactionFee Withdraw fees.
 * @property walletType Wallet type. 0-spot wallet ，1-funding wallet.Default spot wallet.
 */
@ApiModel("The withdrawal history.")
data class WithdrawHistory(
    @ApiModelProperty("Address to withdraw to.") @JsonProperty("address") var address: String? = null,
    @ApiModelProperty("Withdraw date operation.") @JsonProperty("applyTime") var applyTime: String? = null,
    @ApiModelProperty("Coin to withdraw.") @JsonProperty("coin") var coin: String? = null,
    @ApiModelProperty("Withdraw id.") @JsonProperty("id") var id: String? = null,
    @ApiModelProperty(
        "Withdraw order id. will not be returned if there's no withdrawOrderId for this withdraw."
    )
    @JsonProperty
    var withdrawOrderId: String? = null,
    @ApiModelProperty("Network to withdraw on.") @JsonProperty("network") var network: String? = null,
    @ApiModelProperty("Reason for withdrawal failure.") @JsonProperty("info") var info: String? = null,
    @ApiModelProperty("Transaction id.") @JsonProperty("txId") var txId: String? = null,
    @ApiModelProperty("Transaction key.") @JsonProperty("txKey") var txKey: String? = null,
    @ApiModelProperty("1 for internal transfer, 0 for external transfer.")
    @JsonProperty
    var transferType: Int? = null,
    @ApiModelProperty(
        "(0:Email Sent, 1:Cancelled 2:Awaiting Approval 3:Rejected 4:Processing 5:Failure 6:Completed)"
    )
    @JsonProperty
    var status: Int? = null,
    @ApiModelProperty("Confirm times for withdraw.") @JsonProperty("confirmNo") var confirmNo: Int? = null,
    @ApiModelProperty("Withdrawn column.") @JsonProperty("amount") var amount: String? = null,
    @ApiModelProperty("Withdraw fees.") @JsonProperty("transactionFee") var transactionFee: String? = null,
    @ApiModelProperty("Wallet type. 0-spot wallet ，1-funding wallet.Default spot wallet.")
    @JsonProperty
    var walletType: Int? = null
)
