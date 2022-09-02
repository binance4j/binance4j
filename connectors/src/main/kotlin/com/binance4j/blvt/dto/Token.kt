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

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Binance leverage token.
 *
 * @property tokenName token name
 * @property description Description.
 * @property underlying Underlying.
 * @property tokenIssued Token issued.
 * @property basket Basket.
 * @property currentBaskets Current baskets.
 * @property nav Nav.
 * @property realLeverage Real leverage.
 * @property fundingRate Funding rate.
 * @property dailyManagementFee Daily management fee.
 * @property purchaseFeePct Purchase Fee Pct.
 * @property dailyPurchaseLimit Daily Purchase Limit.
 * @property redeemFeePct Redeem Fee Pct.
 * @property dailyRedeemLimit Daily Redeem Limit.
 * @property timestamp Timestamp.
 */
@ApiModel("Binance leverage token.")
data class Token(
	@ApiModelProperty("Token name.")
	var tokenName: String,
	@ApiModelProperty("Description.")
	var description: String,
	@ApiModelProperty("Underlying.")
	var underlying: String,
	@ApiModelProperty("Token issued.")
	var tokenIssued: String,
	@ApiModelProperty("Basket.")
	var basket: String,
	@ApiModelProperty("Current baskets.")
	var currentBaskets: List<Basket>,
	@ApiModelProperty("Nav.")
	var nav: String,
	@ApiModelProperty("Real leverage.")
	var realLeverage: String,
	@ApiModelProperty("Funding rate.")
	var fundingRate: String,
	@ApiModelProperty("Daily management fee.")
	var dailyManagementFee: String,
	@ApiModelProperty("Purchase Fee Pct.")
	var purchaseFeePct: String,
	@ApiModelProperty("Daily Purchase Limit.")
	var dailyPurchaseLimit: String,
	@ApiModelProperty("Redeem Fee Pct.")
	var redeemFeePct: String,
	@ApiModelProperty("Daily Redeem Limit.")
	var dailyRedeemLimit: String,
	@ApiModelProperty("Timestamp.")
	var timestamp: Long,
)