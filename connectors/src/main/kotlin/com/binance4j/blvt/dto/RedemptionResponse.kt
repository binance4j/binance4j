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

package com.binance4j.blvt.dto

import com.fasterxml.jackson.annotation.JsonProperty

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * BLVT redemption response.
 *
 * @property id Subscription id.
 * @property status "Subscription status. S(uccess), P(ending), and F(ailure).
 * @property tokenName Token name.
 * @property amount Redemption value in usdt.
 * @property redeemAmount Redemption token amount.
 * @property timestamp Timestamp in ms.
 */
@ApiModel("BLVT redemption response.")
data class RedemptionResponse(
	@ApiModelProperty("Subscription id.")
	@JsonProperty("id")
	var id: Long,
	@ApiModelProperty("Subscription status. S(uccess), P(ending), and F(ailure).")
	@JsonProperty("status")
	var status: String,
	@ApiModelProperty("Token name.")
	@JsonProperty("tokenName")
	var tokenName: String,
	@ApiModelProperty("Redemption value in usdt.")
	@JsonProperty("redeemAmount")
	var redeemAmount: String,
	@ApiModelProperty("Redemption token amount.")
	@JsonProperty("amount")
	var amount: String,
	@ApiModelProperty("Timestamp in ms.")
	@JsonProperty("timestamp")
	var timestamp: Long,
)
