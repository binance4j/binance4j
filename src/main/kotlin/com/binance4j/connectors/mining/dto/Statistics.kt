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

package com.binance4j.connectors.mining.dto

import com.fasterxml.jackson.annotation.JsonProperty

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
	@JsonProperty("fifteenMinHashRate")
	var fifteenMinHashRate: String,
	@ApiModelProperty("24H Hash rate.")
	@JsonProperty("dayHashRate")
	var dayHashRate: String,
	@ApiModelProperty("Effective quantity.")
	@JsonProperty("validNum")
	var validNum: Int,
	@ApiModelProperty("Invalid quantity.")
	@JsonProperty("invalidNum")
	var invalidNum: Int,
	@ApiModelProperty("Today's estimate.")
	@JsonProperty("profitToday")
	var profitToday: Map<String, String>,
	@ApiModelProperty("Yesterday's earnings.")
	@JsonProperty("profitYesterday")
	var profitYesterday: Map<String, String>,
	@ApiModelProperty("Mining account.")
	@JsonProperty("userName")
	var userName: String,
	@ApiModelProperty("Hash rate unit.")
	@JsonProperty("unit")
	var unit: String,
	@ApiModelProperty("Algorithm.")
	@JsonProperty("algo")
	var algo: String
)
