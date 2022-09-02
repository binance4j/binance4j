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
	@ApiModelProperty("Address to withdraw to.")
	val address: String,
	@ApiModelProperty("Withdraw date operation.")
	val applyTime: String,
	@ApiModelProperty("Coin to withdraw.")
	val coin: String,
	@ApiModelProperty("Withdraw id.")
	val id: String,
	@ApiModelProperty(
		"Withdraw order id. will not be returned if there's no withdrawOrderId for this withdraw."
	)
	val withdrawOrderId: String,
	@ApiModelProperty("Network to withdraw on.")
	val network: String,
	@ApiModelProperty("Reason for withdrawal failure.")
	val info: String,
	@ApiModelProperty("Transaction id.")
	val txId: String,
	@ApiModelProperty("Transaction key.")
	val txKey: String,
	@ApiModelProperty("1 for internal transfer, 0 for external transfer.")
	val transferType: Int,
	@ApiModelProperty(
		"(0:Email Sent, 1:Cancelled 2:Awaiting Approval 3:Rejected 4:Processing 5:Failure 6:Completed)"
	)
	@JsonProperty
	val status: Int,
	@ApiModelProperty("Confirm times for withdraw.")
	val confirmNo: Int,
	@ApiModelProperty("Withdrawn column.")
	val amount: String,
	@ApiModelProperty("Withdraw fees.")
	val transactionFee: String,
	@ApiModelProperty("Wallet type. 0-spot wallet ，1-funding wallet.Default spot wallet.")
	var walletType: Int
)
