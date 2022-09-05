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
	@JsonProperty("asset")
	var asset: String,
	@ApiModelProperty("Borrowed quantity.")
	@JsonProperty("borrowed")
	var borrowed: String,
	@ApiModelProperty("Free quantity.")
	@JsonProperty("free")
	var free: String,
	@ApiModelProperty("Loan interest.")
	@JsonProperty("interest")
	var interest: String,
	@ApiModelProperty("Locked quantity.")
	@JsonProperty("locked")
	var locked: String,
	@ApiModelProperty("Net asset quantity.")
	@JsonProperty("netAsset")
	var netAsset: String,
	@ApiModelProperty("Net asset of Bitcoin.")
	@JsonProperty("netAssetOfBtc")
	var netAssetOfBtc: String,
	@ApiModelProperty("Asset total quantity.")
	@JsonProperty("totalAsset")
	var totalAsset: String,
	@ApiModelProperty("Can the account borrow this asset?")
	@JsonProperty("borrowEnabled")
	var borrowEnabled: Boolean,
	@ApiModelProperty("Can the account repay this asset?")
	@JsonProperty("repayEnabled")
	var repayEnabled: Boolean
)
