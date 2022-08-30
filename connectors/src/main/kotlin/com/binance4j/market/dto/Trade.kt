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
 * An executed trade history item.
 *
 * @property id           Trade id.
 * @property price        Trad price.
 * @property qty          Trade volume.
 * @property quoteQty     Trade opposite volume.
 * @property time         Trade execution in ms.
 * @property isBuyerMaker Is the trade a buyer maker trade.
 * @property isBestMatch  Was the trade the best price match?
 */
@ApiModel("An executed trade history item.")
data class Trade(
	@ApiModelProperty("Trade id.")
	val id: Long,
	@ApiModelProperty("Trad price.")
	val price: String,
	@ApiModelProperty("Trade volume.")
	val qty: String,
	@ApiModelProperty("Trade opposite volume.")
	val quoteQty: String,
	@ApiModelProperty("Trade execution in ms.")
	val time: Long,
	@ApiModelProperty("Is the trade a buyer maker trade.")
	val isBuyerMaker: Boolean,
	@ApiModelProperty("Was the trade the best price match?")
	val isBestMatch: Boolean
)

