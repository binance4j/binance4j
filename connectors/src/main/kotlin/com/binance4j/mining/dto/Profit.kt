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

package com.binance4j.mining.dto

import com.fasterxml.jackson.annotation.JsonProperty

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Account profit.
 *
 * @property time           Mining date in ms.
 * @property hashTransfer   Transferred Hash rate.
 * @property transferAmount Transferred Income.
 * @property dayHashRate    Daily Hash rate.
 * @property profitAmount   Earnings Amount.
 * @property coinName       Coin type.
 * @property type           Type. 0: Mining Wallet 5: Mining Address 7: Pool Savings 8: Transferred 31: Income Transfer 32: Hash rate Resale-Mining Wallet 33: Hash rate Resale-Pool Savings
 * @property status         Status. 0: Unpaid 1: Paying 2: Paid
 */
@ApiModel("Account profit.")
data class Profit(
	@ApiModelProperty("Mining date in ms.")
	@JsonProperty("time")
	var time: Long,
	@ApiModelProperty("Transferred Hash rate.")
	@JsonProperty("type")
	var type: Int,
	@ApiModelProperty("Transferred Income.")
	@JsonProperty("hashTransfer")
	var hashTransfer: Long,
	@ApiModelProperty("Daily Hash rate.")
	@JsonProperty("transferAmount")
	var transferAmount: String,
	@ApiModelProperty("Earnings Amount.")
	@JsonProperty("dayHashRate")
	var dayHashRate: Long,
	@ApiModelProperty("Coin type.")
	@JsonProperty("profitAmount")
	var profitAmount: String,
	@ApiModelProperty("Type. 0: Mining Wallet 5: Mining Address 7: Pool Savings 8: Transferred 31: Income Transfer 32: Hash rate Resale-Mining Wallet 33: Hash rate Resale-Pool Savings")
	@JsonProperty("coinName")
	var coinName: String,
	@ApiModelProperty("Status. 0: Unpaid 1: Paying 2: Paid")
	@JsonProperty("status")
	var status: Int
)