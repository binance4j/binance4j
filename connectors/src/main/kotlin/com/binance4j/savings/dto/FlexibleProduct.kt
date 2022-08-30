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
 * A Flexible product.
 *
 * @property asset                    Asset.
 * @property avgAnnualInterestRate    Avg annual interest rate.
 * @property tierAnnualInterestRate   Tier annual interest rate.
 * @property latestAnnualInterestRate Latest annual interest rate.
 * @property canPurchase              Product can be purchase?
 * @property canRedeem                Product can be redeemed?
 * @property featured                 Featured.
 * @property minPurchaseAmount        Min purchase amount.
 * @property productId                Product id.
 * @property purchasedAmount          Purchased amount.
 * @property status                   Status.
 * @property upLimit                  Up limit.
 * @property upLimitPerUser           Up limit per user.
 */
@ApiModel("A Flexible product.")
data class FlexibleProduct(
	@ApiModelProperty("Asset.")
	val asset: String,
	@ApiModelProperty("Avg annual interest rate.")
	val avgAnnualInterestRate: String,
	@ApiModelProperty("Tier annual interest rate.")
	var tierAnnualInterestRate: Map<String, String>,
	@ApiModelProperty("Latest annual interest rate.")
	val latestAnnualInterestRate: String,
	@ApiModelProperty("Product can be purchase?")
	val canPurchase: Boolean,
	@ApiModelProperty("Product can be redeemed?")
	val canRedeem: Boolean,
	@ApiModelProperty("Featured.")
	val featured: Boolean,
	@ApiModelProperty("Min purchase amount.")
	val minPurchaseAmount: String,
	@ApiModelProperty("Product id.")
	val productId: String,
	@ApiModelProperty("Purchased amount.")
	val purchasedAmount: String,
	@ApiModelProperty("Status.")
	val status: String,
	@ApiModelProperty("Up limit.")
	val upLimit: String,
	@ApiModelProperty("Up limit per user.")
	val upLimitPerUser: String
)
