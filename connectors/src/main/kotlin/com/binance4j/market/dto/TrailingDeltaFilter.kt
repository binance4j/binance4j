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

package com.binance4j.market.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * The minimum and maximum value for the parameter trailingDelta.
 *
 * @property minTrailingAboveDelta Min trailing above delta.
 * @property maxTrailingAboveDelta Max trailing above delta.
 * @property minTrailingBelowDelta Min trailing below delta.
 * @property maxTrailingBelowDelta Max trailing below delta.
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@ApiModel("The minimum and maximum value for the parameter trailingDelta.")
data class TrailingDeltaFilter(
	@ApiModelProperty("Min trailing above delta.")
	val minTrailingAboveDelta: String,
	@ApiModelProperty("Max trailing above delta.")
	val maxTrailingAboveDelta: String,
	@ApiModelProperty("Min trailing below delta.")
	val minTrailingBelowDelta: String,
	@ApiModelProperty("Max trailing below delta.")
	val maxTrailingBelowDelta: String
)