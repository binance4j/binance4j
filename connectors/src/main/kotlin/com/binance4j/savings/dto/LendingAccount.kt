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

package com.binance4j.savings.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Lending account.
 *
 * @property positionAmountVos      Position amount.
 * @property totalAmountInBTC       Total amount in btc.
 * @property totalAmountInUSDT      Total amount in usdt.
 * @property totalFixedAmountInBTC  Total fixed amount in btc.
 * @property totalFixedAmountInUSDT Total fixed amount in usdt.
 * @property totalFlexibleInBTC     Total flexible in btc.
 * @property totalFlexibleInUSDT    Total flexible in usdt.
 */
@ApiModel("Lending account.")
data class LendingAccount(
	@ApiModelProperty("Position amount.")
	val positionAmountVos: List<PositionAmount>,
	@ApiModelProperty("Total amount in btc.")
	val totalAmountInBTC: String,
	@ApiModelProperty("Total amount in usdt.")
	val totalAmountInUSDT: String,
	@ApiModelProperty("Total fixed amount in btc.")
	val totalFixedAmountInBTC: String,
	@ApiModelProperty("Total fixed amount in usdt.")
	val totalFixedAmountInUSDT: String,
	@ApiModelProperty("Total flexible in btc.")
	val totalFlexibleInBTC: String,
	@ApiModelProperty("Total flexible in usdt.")
	val totalFlexibleInUSDT: String
)
