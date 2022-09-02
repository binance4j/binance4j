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

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * An isolated {@link Asset} pair.
 *
 * @property symbol        Asset pair.
 * @property base          Base asset.
 * @property quote         Quote asset.
 * @property isMarginTrade Is margin trade allowed?
 * @property isBuyAllowed  Is purchase allowed?
 * @property isSellAllowed Is sale allowed?
 */
@ApiModel("An isolated asset pair.")
data class IsolatedSymbol(
	@ApiModelProperty("Asset pair.")
	val symbol: String,
	@ApiModelProperty("Base asset.")
	val base: String,
	@ApiModelProperty("Quote asset.")
	val quote: String,
	@ApiModelProperty("Is margin trade allowed?")
	val isMarginTrade: Boolean,
	@ApiModelProperty("Is purchase allowed?")
	val isBuyAllowed: Boolean,
	@ApiModelProperty("Is sale allowed?") val isSellAllowed: Boolean
)
