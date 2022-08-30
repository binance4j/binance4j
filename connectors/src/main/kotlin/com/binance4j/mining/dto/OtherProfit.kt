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
 * Other profit.
 *
 * @property time         Mining date.
 * @property coinName     Coin Name.
 * @property profitAmount Amount.
 * @property status       Status. 0: Unpaid 1: Paying 2：Paid
 * @property type         Type. 1: Merged Mining 2: Activity Bonus 3: Rebate 4:Smart Pool 6: Income Transfer 7: PoolSavings
 */
@ApiModel("Other profit.")
data class OtherProfit(
	@ApiModelProperty("Mining date.")
	val time: Long,
	@ApiModelProperty("Coin Name.")
	val coinName: String,
	@ApiModelProperty("Amount.")
	var type: Int,
	@ApiModelProperty("Status. 0: Unpaid 1: Paying 2：Paid")
	var profitAmount: String,
	@ApiModelProperty("Type.1: Merged Mining 2: Activity Bonus 3: Rebate 4: Smart Pool 6: Income Transfer 7: Pool Savings")
	var status: Int
)