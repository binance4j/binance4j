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
package com.binance4j.rebate.client

import com.binance4j.core.Binance4j
import com.binance4j.core.exception.ApiException
import com.binance4j.core.param.FramedPaging
import com.binance4j.core.test.CustomTest
import com.fasterxml.jackson.databind.DeserializationFeature
import org.junit.jupiter.api.Test

class RebateClientTest : CustomTest() {
	var client = RebateClient(key, secret)
	
	@Test
	@Throws(ApiException::class)
	fun testGetSpotRebateHistoryRecords() {
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
		assertNotThrow(client.getSpotRebateHistoryRecords())
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetSpotRebateHistoryRecords2() {
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
		assertNotThrow(client.getSpotRebateHistoryRecords(FramedPaging(1)))
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	}
}