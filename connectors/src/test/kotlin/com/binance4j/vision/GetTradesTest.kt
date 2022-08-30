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

package com.binance4j.vision

import com.binance4j.core.exception.ApiException
import com.binance4j.core.exception.InvalidDateException
import com.binance4j.core.exception.NotFoundException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

class GetTradesTest : SpotTest() {
	@Test
	fun testInvalidDate() {
		val exception: Exception = Assertions.assertThrows(
			ApiException::class.java
		) { client.getTrades(symbol, year, month, "32").getData() }
		Assertions.assertTrue(exception.message!!.contains(InvalidDateException().message))
	}
	
	@Test
	fun testNotFoundSync() {
		val exception: Exception = Assertions.assertThrows(
			ApiException::class.java
		) { client.getTrades(symbol, "1995", month, day).getData() }
		Assertions.assertTrue(exception.message!!.contains(NotFoundException().message))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetTrades() {
		assertNotNull(client.getTrades(symbol, year, month, day).getData())
	}
}