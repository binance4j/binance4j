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
 * Interest record in a {@link InterestHistory}.
 *
 * @property isolatedSymbol      Isolated symbol. Will not be returned for crossed
 *                            margin.
 * @property asset               Related asset.
 * @property rawAsset            Related raw asset. Will not be returned for
 *                            isolated margin.
 * @property interest            Interest.
 * @property interestAccuredTime Interest accrued (?) time.
 * @property interestRate        Interest rate.
 * @property principal           Borrowed quantity (?).
 * @property type                Interest type.
 * @see InterestType
 */
@ApiModel("Interest record in a InterestHistory.")
data class InterestRecord(
	@ApiModelProperty("Isolated symbol. Will not be returned for crossed margin.")
	var isolatedSymbol: String,
	@ApiModelProperty("Related asset.")
	var asset: String,
	@ApiModelProperty("Related raw asset. Will not be returned for isolated margin.")
	var rawAsset: String,
	@ApiModelProperty("Interest.")
	var interest: String,
	@ApiModelProperty("Interest accrued (?) time.")
	var interestAccuredTime: Long,
	@ApiModelProperty("Interest rate.")
	var interestRate: String,
	@ApiModelProperty("Borrowed quantity (?).")
	var principal: String,
	@ApiModelProperty("Interest type.")
	var type: String
)