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
 * Statistics.
 *
 * @property fifteenMinHashRate 15 mins hash rate.
 * @property dayHashRate        24H Hash rate.
 * @property validNum           Effective quantity.
 * @property invalidNum         Invalid quantity.
 * @property profitToday        Today's estimate.
 * @property profitYesterday    Yesterday's earnings.
 * @property userName           Mining account.
 * @property unit               Hash rate unit.
 * @property algo               Algorithm.
 */
@ApiModel("Statistics.")
data class Statistics(
	@ApiModelProperty("15 mins hash rate.")
	var fifteenMinHashRate: String,
	@ApiModelProperty("24H Hash rate.")
	var dayHashRate: String,
	@ApiModelProperty("Effective quantity.")
	var validNum: Int,
	@ApiModelProperty("Invalid quantity.")
	var invalidNum: Int,
	@ApiModelProperty("Today's estimate.")
	var profitToday: Map<String, String>,
	@ApiModelProperty("Yesterday's earnings.")
	var profitYesterday: Map<String, String>,
	@ApiModelProperty("Mining account.")
	var userName: String,
	@ApiModelProperty("Hash rate unit.")
	var unit: String,
	@ApiModelProperty("Algorithm.")
	var algo: String
)
