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

package com.binance4j.spot.dto


import com.binance4j.core.dto.AssetBalance
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * The SPOT account information.
 *
 * @property makerCommission  Maker commission.
 * @property takerCommission  Taker commission.
 * @property buyerCommission  Buyer commission.
 * @property sellerCommission Seller commission.
 * @property canTrade         Trade permission.
 * @property canWithdraw      Withdrawal permission.
 * @property canDeposit       Deposit permission.
 * @property updateTime       Timestamp of the last data update.
 * @property balances         Balances of each asset in the SPOT wallet.
 * @property accountType      Account Type .
 * @property permissions      Permissions list.
 * @property brokered         Brokered account?
 */
@ApiModel("The SPOT account information.")
data class Account(
	@ApiModelProperty("Maker commission.")
	val makerCommission: String,
	@ApiModelProperty("Taker commission.")
	val takerCommission: String,
	@ApiModelProperty("Buyer commission.")
	val buyerCommission: String,
	@ApiModelProperty("Seller commission.")
	val sellerCommission: String,
	@ApiModelProperty("Trade permission.")
	val canTrade: Boolean,
	@ApiModelProperty("Withdrawal permission.")
	val canWithdraw: Boolean,
	@ApiModelProperty("Deposit permission.")
	val canDeposit: Boolean,
	@ApiModelProperty("Timestamp of the last data update.")
	val updateTime: Long,
	@ApiModelProperty("Balances of each asset in the SPOT wallet.")
	var balances: List<AssetBalance>,
	@ApiModelProperty("Account Type .")
	val accountType: String,
	@ApiModelProperty("Permissions list.")
	var permissions: List<String>,
	@ApiModelProperty("Brokered account?")
	val brokered: Boolean
)