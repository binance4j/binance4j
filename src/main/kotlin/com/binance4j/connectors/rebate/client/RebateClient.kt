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
package com.binance4j.connectors.rebate.client

import com.binance4j.connectors.core.Request
import com.binance4j.connectors.core.client.RestClient

/**
 * The API client for the SPOT endpoints
 *
 * [Documentation](https://binance-docs.github.io/apidocs/spot/en/#rebate-endpoints)
 */
object RebateClient : RestClient<RebateMapping>(RebateMapping::class.java) {
	/**
	 * Get the spot rebate history records.
	 *
	 * @property startTime Start time in ms.
	 * @property endTime   End time in ms.
	 * @property page      Result page.
	 * @property limit     Results in the page.
	 *
	 * @return The request to execute.
	 */
	@JvmOverloads
	fun getSpotRebateHistoryRecords(startTime: Long? = null, endTime: Long? = null, page: Int? = null, limit: Int? = null) =
		Request(service.getSpotRebateHistoryRecords(startTime, endTime, page, limit))
}