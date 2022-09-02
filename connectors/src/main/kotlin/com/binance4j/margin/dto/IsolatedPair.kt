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

import com.fasterxml.jackson.annotation.JsonProperty

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Isolated asset pair in an {@link IsolatedAccount}
 *
 * @property baseAsset         Base asset.
 * @property quoteAsset        Quote asset.
 * @property symbol            Asset symbol.
 * @property isolatedCreated   is isolated asset created.
 * @property tradeEnabled      Is trading enabled?
 * @property enabled           Is the pair enabled for the account?
 * @property marginLevelStatus Margin level status.
 * @property marginLevel       Margin level.
 * @property marginRatio       Margin ratio.
 * @property indexPrice        Index price.
 * @property liquidatePrice    Liquidate price.
 * @property liquidateRate     Liquidate rate.
 * @see LevelStatus
 */
@ApiModel("Isolated asset pair in an isolated account.")
data class IsolatedPair(
	@ApiModelProperty("Base asset.")
	@JsonProperty("baseAsset")
	var baseAsset: IsolatedAsset? = null,
	@ApiModelProperty("Quote asset.")
	@JsonProperty("quoteAsset")
	var quoteAsset: IsolatedAsset? = null,
	@ApiModelProperty("Asset symbol.")
	@JsonProperty("symbol")
	var symbol: String,
	@ApiModelProperty("is isolated asset created.")
	@JsonProperty("isolatedCreated")
	var isolatedCreated: Boolean,
	@ApiModelProperty("Is trading enabled?")
	@JsonProperty("tradeEnabled")
	var tradeEnabled: Boolean,
	@ApiModelProperty("Is the pair enabled for the account?")
	@JsonProperty("enabled")
	var enabled: Boolean,
	@ApiModelProperty("Margin level status.")
	@JsonProperty("marginLevelStatus")
	var marginLevelStatus: String,
	@ApiModelProperty("Margin level.")
	@JsonProperty("marginLevel")
	var marginLevel: String,
	@ApiModelProperty("Margin ratio.")
	@JsonProperty("marginRatio")
	var marginRatio: String,
	@ApiModelProperty("Index price.")
	@JsonProperty("indexPrice")
	var indexPrice: String,
	@ApiModelProperty("Liquidate price.")
	@JsonProperty("liquidatePrice")
	var liquidatePrice: String,
	@ApiModelProperty("Liquidate rate.")
	@JsonProperty("liquidateRate")
	var liquidateRate: String
)
