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

package com.binance4j.margin.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Data about a repay.
 *
 * @property txId           Transaction id.
 * @property timestamp      Transaction timestamp in ms.
 * @property isolatedSymbol Isolated symbol, will not be returned for crossed margin.
 * @property amount         Total amount repaid.
 * @property asset          Asset.
 * @property interest       Interest repaid.
 * @property principal      Quantity repaid.
 * @property status         Repay status.
 * @see LoanStatus
 */
@ApiModel("Data about a repay.")
data class RepayRecord(
	@ApiModelProperty("Transaction id.")
	val txId: Long,
	@ApiModelProperty("Transaction timestamp in ms.")
	val timestamp: Long,
	@ApiModelProperty("Isolated symbol, will not be returned for crossed margin.")
	var isolatedSymbol: String,
	@ApiModelProperty("Total amount repaid.")
	val amount: String,
	@ApiModelProperty("Asset.")
	val asset: String,
	@ApiModelProperty("Interest repaid.")
	val interest: String,
	@ApiModelProperty("Quantity repaid.")
	val principal: String,
	@ApiModelProperty("Repay status.")
	val status: String
)