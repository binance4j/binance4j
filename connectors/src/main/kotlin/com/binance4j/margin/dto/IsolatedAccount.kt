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
 * Isolated margin account info.
 *
 * @property assets              Owned assets.
 * @property totalAssetOfBtc     Total asset of Bitcoin.
 * @property totalLiabilityOfBtc Total liability of Bitcoin.
 * @property totalNetAssetOfBtc  Total net asset of Bitcoin.
 */
@ApiModel("Isolated margin account info.")
data class IsolatedAccount(
	@ApiModelProperty("Owned assets.")
	var assets: List<IsolatedPair>,
	@ApiModelProperty("Total asset of Bitcoin.")
	var totalAssetOfBtc: String,
	@ApiModelProperty("Total liability of Bitcoin.")
	var totalLiabilityOfBtc: String,
	@ApiModelProperty("Total net asset of Bitcoin.")
	var totalNetAssetOfBtc: String
)
