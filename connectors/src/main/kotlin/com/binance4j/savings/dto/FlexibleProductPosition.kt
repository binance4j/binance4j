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

import com.fasterxml.jackson.annotation.JsonProperty

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Flexible product position.
 *
 * @property tierAnnualInterestRate Tier annual interest rate.
 * @property annualInterestRate     Annual interest rate.
 * @property asset                  Asset.
 * @property avgAnnualInterestRate  Avg annual interest rate.
 * @property canRedeem              Can redeem.
 * @property dailyInterestRate      Daily interest rate.
 * @property freeAmount             Free amount.
 * @property freezeAmount           Freeze amount.
 * @property lockedAmount           Locked amount.
 * @property productId              Product id.
 * @property productName            Product name.
 * @property redeemingAmount        Redeeming amount.
 * @property todayPurchasedAmount   Today purchased amount.
 * @property totalAmount            Total amount.
 * @property totalInterest          Total interest.
 */
@ApiModel("Flexible product position.")
data class FlexibleProductPosition(
	@ApiModelProperty("Tier annual interest rate.")
	@JsonProperty("tierAnnualInterestRate")
	var tierAnnualInterestRate: Map<String, String>,
	@ApiModelProperty("Annual interest rate.")
	@JsonProperty("annualInterestRate")
	var annualInterestRate: String,
	@ApiModelProperty("Asset.")
	@JsonProperty("asset")
	var asset: String,
	@ApiModelProperty("Avg annual interest rate.")
	@JsonProperty("avgAnnualInterestRate")
	var avgAnnualInterestRate: String,
	@ApiModelProperty("Can redeem.")
	@JsonProperty("canRedeem")
	var canRedeem: Boolean,
	@ApiModelProperty("Daily interest rate.")
	@JsonProperty("dailyInterestRate")
	var dailyInterestRate: String,
	@ApiModelProperty("Free amount.")
	@JsonProperty("freeAmount")
	var freeAmount: String,
	@ApiModelProperty("Freeze amount.")
	@JsonProperty("freezeAmount")
	var freezeAmount: String,
	@ApiModelProperty("Locked amount.")
	@JsonProperty("lockedAmount")
	var lockedAmount: String,
	@ApiModelProperty("Product id.")
	@JsonProperty("productId")
	var productId: String,
	@ApiModelProperty("Product name.")
	@JsonProperty("productName")
	var productName: String,
	@ApiModelProperty("Redeeming amount.")
	@JsonProperty("redeemingAmount")
	var redeemingAmount: String,
	@ApiModelProperty("Today purchased amount.")
	@JsonProperty("todayPurchasedAmount")
	var todayPurchasedAmount: String,
	@ApiModelProperty("Total amount.")
	@JsonProperty("totalAmount")
	var totalAmount: String,
	@ApiModelProperty("Total interest.")
	@JsonProperty("totalInterest")
	var totalInterest: String
)