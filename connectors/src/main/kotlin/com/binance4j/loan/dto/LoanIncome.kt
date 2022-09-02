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

package com.binance4j.loan.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * A loan income.
 *
 * @property asset     Income asset.
 * @property type      Income type.
 * @property amount    Income amount.
 * @property timestamp Timestamp in ms.
 * @property tranId    Transaction id.
 */
@ApiModel("A loan income.")
data class LoanIncome(
	@ApiModelProperty("Income asset.")
	@JsonProperty("asset")
	var asset: String,
	@ApiModelProperty("Income type.")
	@JsonProperty("type")
	var type: String,
	@ApiModelProperty("Income amount.")
	@JsonProperty("amount")
	var amount: String,
	@ApiModelProperty("Timestamp in ms.")
	@JsonProperty("timestamp")
	var timestamp: Long,
	@ApiModelProperty("Transaction id.")
	@JsonProperty("tranId")
	var tranId: String
)