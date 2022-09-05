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
 * Hash rate resale detail.
 *
 * @property poolUsername   Transfer out of subaccount.
 * @property toPoolUsername Transfer into subaccount.
 * @property algoName       Transfer algorithm.
 * @property hashRate       Transferred Hash rate quantity.
 * @property day            Transfer date.
 * @property amount         Transferred income.
 * @property coinName       Coin Name.
 */
@ApiModel("Hash rate resale detail.")
data class HashrateResaleDetail(
	@ApiModelProperty("Transfer out of sub-account.")
	@JsonProperty("poolUsername")
	var poolUsername: String,
	@ApiModelProperty("Transfer into sub account.")
	@JsonProperty("toPoolUsername")
	var toPoolUsername: String,
	@ApiModelProperty("Transfer algorithm.")
	@JsonProperty("algoName")
	var algoName: String,
	@ApiModelProperty("Transferred Hash rate quantity.")
	@JsonProperty("hashRate")
	var hashRate: Long,
	@ApiModelProperty("Transfer date.")
	@JsonProperty("day")
	var day: Long,
	@ApiModelProperty("Transferred income.")
	@JsonProperty("amount")
	var amount: String,
	@ApiModelProperty("Coin Name.")
	@JsonProperty("coinName")
	var coinName: String
)
