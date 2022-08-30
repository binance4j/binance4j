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

package com.binance4j.fiat.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * A fiat transaction.
 *
 * @property orderNo Order No.
 * @property fiatCurrency Fiat currency.
 * @property indicatedAmount Indicated amount.
 * @property amount Amount.
 * @property totalFee Total fee.
 * @property method Method.
 * @property status Status.
 * @property createTime Create time in ms.
 * @property updateTime Update time in ms.
 */
@ApiModel("A fiat transaction.")
data class Transaction(
	@ApiModelProperty("Order No.")
	val orderNo: String,
	@ApiModelProperty("Fiat currency.")
	val fiatCurrency: String,
	@ApiModelProperty("Indicated amount.")
	val indicatedAmount: String,
	@ApiModelProperty("Amount.")
	val amount: String,
	@ApiModelProperty("Total fee.")
	val totalFee: String,
	@ApiModelProperty("Method.")
	val method: String,
	@ApiModelProperty("Status.")
	val status: String,
	@ApiModelProperty("Create time in ms.")
	val createTime: Long,
	@ApiModelProperty("Update time in ms.")
	val updateTime: Long,
)