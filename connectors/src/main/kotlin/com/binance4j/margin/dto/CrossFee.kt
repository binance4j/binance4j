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
 * Cross margin fee data collection with any vip level or user's current
 * specific data as
 * <a href="https://www.binance.com/en/margin-fee">here</a>
 *
 * @property vipLevel        User's VIP level.
 * @property coin            Coin name.
 * @property borrowLimit     Borrow limit.
 * @property dailyInterest   Daily interest.
 * @property yearlyInterest  Yearly interest.
 * @property borrowable      Is it borrowable?
 * @property transferIn      Is internal transfer allowed?
 * @property marginablePairs Bound pairs.
 */
@ApiModel("Cross margin fee data collection")
data class CrossFee(
	@ApiModelProperty("User's VIP level.")
	var vipLevel: Int,
	@ApiModelProperty("Coin name.")
	var coin: String,
	@ApiModelProperty("Borrow limit.")
	var borrowLimit: String,
	@ApiModelProperty("Daily interest.")
	var dailyInterest: String,
	@ApiModelProperty("Yearly interest.")
	var yearlyInterest: String,
	@ApiModelProperty("Is it borrowable?")
	var borrowable: Boolean,
	@ApiModelProperty("Is internal transfer allowed?")
	var transferIn: Boolean,
	@ApiModelProperty("Bound pairs.")
	var marginablePairs: List<String>
)