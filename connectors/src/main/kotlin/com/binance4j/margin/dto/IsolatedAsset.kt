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
 * Isolated asset in {@link IsolatedPair}.
 *
 * @property asset         Asset name.
 * @property borrowEnabled Borrowed quantity.
 * @property repayEnabled  Free quantity.
 * @property borrowed      Loan interest.
 * @property free          Locked quantity.
 * @property interest      Net asset quantity.
 * @property locked        Net asset of Bitcoin.
 * @property netAsset      Asset total quantity.
 * @property netAssetOfBtc Can the account borrow this asset?
 * @property totalAsset    Can the account repay this asset?
 */
@ApiModel("Isolated asset in isolated pair.")
data class IsolatedAsset(
	@ApiModelProperty("Asset name.")
	val asset: String,
	@ApiModelProperty("Borrowed quantity.")
	val borrowed: String,
	@ApiModelProperty("Free quantity.")
	val free: String,
	@ApiModelProperty("Loan interest.")
	val interest: String,
	@ApiModelProperty("Locked quantity.")
	val locked: String,
	@ApiModelProperty("Net asset quantity.")
	val netAsset: String,
	@ApiModelProperty("Net asset of Bitcoin.")
	val netAssetOfBtc: String,
	@ApiModelProperty("Asset total quantity.")
	val totalAsset: String,
	@ApiModelProperty("Can the account borrow this asset?")
	val borrowEnabled: Boolean,
	@ApiModelProperty("Can the account repay this asset?")
	val repayEnabled: Boolean
)
