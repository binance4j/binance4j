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

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Account profit.
 *
 * @property time     Time in ms.
 * @property coinName Coin.
 * @property type     0:Referral 1：Refund 2：Rebate.
 * @property puid     Sub-account id.
 * @property subName  Mining account.
 * @property amount   Amount.
 */
@ApiModel("Account profit.")
data class AccountProfit(
	@ApiModelProperty("Time in ms.")
	val time: Long,
	@ApiModelProperty("Coin.")
	val coinName: String,
	@ApiModelProperty("0:Referral 1：Refund 2：Rebate.")
	val type: Int,
	@ApiModelProperty("Sub-account id.")
	val puid: Int,
	@ApiModelProperty("Mining account.")
	val subName: String,
	@ApiModelProperty("Amount.")
	val amount: String
)
