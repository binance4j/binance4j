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
 * An asset dividend.
 *
 * @property amount Dividend amount.
 * @property enInfo Info about the asset.
 * @property asset Asset abbreviation.
 * @property id Id.
 * @property divTime Dividend time in ms.
 * @property tranId Transaction id.
 */
@ApiModel("An asset dividend.")
data class AssetDividend(
	@ApiModelProperty("Dividend amount.")
	val amount: String,
	@ApiModelProperty("Info about the asset.")
	val enInfo: String,
	@ApiModelProperty("Asset abbreviation.")
	val asset: String,
	@ApiModelProperty("Id.")
	val id: Long,
	@ApiModelProperty("Dividend time in ms.")
	val divTime: Long,
	@ApiModelProperty("Transaction id.")
	val tranId: Long,
)
