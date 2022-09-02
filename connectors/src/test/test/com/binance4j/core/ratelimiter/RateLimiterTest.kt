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

package com.binance4j.core.ratelimiter

import com.binance4j.core.dto.RateLimit
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.floor

class RateLimiterTest {
	@Test
	fun testRateLimiterForMinute() {
		val limiter = RateLimiter(RateLimit("WEIGHT", "MINUTE", 1, 1200))
		Assertions.assertEquals(limiter.rate, 1200 / 60)
	}
	
	@Test
	fun testRateLimiterForSecond() {
		val limiter = RateLimiter(RateLimit("WEIGHT", "SECOND", 10, 50))
		Assertions.assertEquals(limiter.rate, 50 / 10)
	}
	
	@Test
	fun testRateLimiterForDay() {
		val limiter = RateLimiter(RateLimit("WEIGHT", "DAY", 1, 160000))
		Assertions.assertEquals(limiter.rate.toDouble(), floor((160000 / RateLimitInterval.DAY.value).toDouble()))
	}
	
	@Test
	@Throws(InterruptedException::class)
	fun testAcquireTime() {
		Assertions.assertDoesNotThrow {
			val before = System.currentTimeMillis()
			val turns = 100
			val intervalNum = 1
			val limit = 10
			val rateLimit = RateLimit("WEIGHT", "SECOND", intervalNum, limit)
			val limiter = RateLimiter(rateLimit)
			val estimatedTime = 100 / (limit * intervalNum)
			for (i in 0 until turns) {
				limiter.acquire(1)
			}
			val time = (System.currentTimeMillis() - before) / 1000
			println(time)
			Assertions.assertEquals(time, estimatedTime.toLong())
		}
	}
}