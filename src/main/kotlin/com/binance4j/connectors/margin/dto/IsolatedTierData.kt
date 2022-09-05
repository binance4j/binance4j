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

package com.binance4j.connectors.margin.dto

import com.fasterxml.jackson.annotation.JsonProperty

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * The tiers for the number of Base Coins Borrowings and Quote Coins Borrowings
 * currently exist in your account. Your
 * Isolated Margin account tier is determined by whichever is higher. Each tier
 * corresponds to a different Initial Risk
 * Rate and Liquidation Risk Ratio, and the Initial Risk Ratio determines your
 * highest available leverage multiple.
 *
 * @property symbol                  Related symbol.
 * @property tier                    Tier.
 * @property effectiveMultiple       Effective multiple.
 * @property initialRiskRatio        Initial risk ratio.
 * @property liquidationRiskRatio    Liquidation risk ratio.
 * @property baseAssetMaxBorrowable  Base asset max borrowable.
 * @property quoteAssetMaxBorrowable Quote asset max borrowable.
 * @see <a href="https://www.binance.com/en/margin-data">Documentation</a>
 */
@ApiModel("The tiers for the number of Base Coins Borrowings and Quote Coins Borrowings currently exist in your account.")
data class IsolatedTierData(
	@ApiModelProperty("Related symbol.")
	@JsonProperty("symbol")
	var symbol: String,
	@ApiModelProperty("Tier.")
	@JsonProperty("tier")
	var tier: Int,
	@ApiModelProperty("Effective multiple.")
	@JsonProperty("effectiveMultiple")
	var effectiveMultiple: String,
	@ApiModelProperty("Initial risk ratio.")
	@JsonProperty("initialRiskRatio")
	var initialRiskRatio: String,
	@ApiModelProperty("Liquidation risk ratio.")
	@JsonProperty("liquidationRiskRatio")
	var liquidationRiskRatio: String,
	@ApiModelProperty("Base asset max borrowable.")
	@JsonProperty("baseAssetMaxBorrowable")
	var baseAssetMaxBorrowable: String,
	@ApiModelProperty("Quote asset max borrowable.")
	@JsonProperty("quoteAssetMaxBorrowable")
	var quoteAssetMaxBorrowable: String
)
