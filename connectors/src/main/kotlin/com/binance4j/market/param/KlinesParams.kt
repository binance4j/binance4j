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

package com.binance4j.market.param

import com.binance4j.core.dto.CandlestickInterval
import com.binance4j.market.client.MarketClient

/**
 * [MarketClient.getKlines] params.
 *
 * @param symbol   Trading pair we want the data.
 * @param interval Candlestick interval.
 * @param startTime Start time in ms.
 * @param endTime   End time in ms.
 * @param limit     Results limit.
 */
data class KlinesParams @JvmOverloads constructor(
	var symbol: String,
	var interval: String,
	var startTime: Long? = null,
	var endTime: Long? = null,
	var limit: Int? = null
) : MarketParams {
	@JvmOverloads
	constructor(
		symbol: String,
		interval: CandlestickInterval,
		startTime: Long? = null,
		endTime: Long? = null,
		limit: Int? = null
	) : this(symbol, interval.toString(), startTime, endTime, limit)
}