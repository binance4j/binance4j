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

package com.binance4j.wallet.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Details about an asset dust transfer (conversion into BNB).
 *
 * @property amount Amount of volume converted.
 * @property fromAsset Converted asset abbreviation.
 * @property operateTime Operation timestamp.
 * @property serviceChargeAmount Fees.
 * @property tranId Transaction id.
 * @property transferedAmount Transferred amount after fees.
 */
@ApiModel("Details about an asset dust transfer (conversion into BNB).")
data class DustTransferResult(
	@ApiModelProperty("Amount of volume converted.")
	val amount: String,
	@ApiModelProperty("Converted asset abbreviation.")
	val fromAsset: String,
	@ApiModelProperty("Operation timestamp.")
	val operateTime: Long,
	@ApiModelProperty("Fees.")
	val serviceChargeAmount: String,
	@ApiModelProperty("Transaction id.")
	val tranId: Long,
	@ApiModelProperty("Transferred amount after fees.")
	val transferedAmount: String
)