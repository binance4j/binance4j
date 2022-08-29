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

import com.binance4j.connectors.Connectors
import com.binance4j.core.client.RateLimits
import com.binance4j.core.exception.ApiException
import kotlin.system.exitProcess

/**
 * Wrapper for all rate limiters
 */
class RateLimiting private constructor() {
	
	lateinit var rawRequestLimiter: RateLimiter
		private set
	
	lateinit var requestWeightLimiter: RateLimiter
		private set
	
	lateinit var rateLimits: RateLimits
		private set
	
	/** Is Rate limit enabled? */
	val isEnabled: Boolean
		private set
	
	/** Enables global rate limiting. */
	fun enable() {
		isEnabled = true
	}
	
	/** Disables global rate limiting. */
	fun disable() {
		isEnabled = false
	}
	
	/**
	 * Fetches rate limits and creates instance of rate limiters
	 */
	init {
		// Fetch rate limit data
		try {
			disable()
			// init raw request and request weight limiter with data
			// TODO correct
			rateLimits = Connectors.`rest()`.market().getExchangeInfo()
			rawRequestLimiter = RateLimiter(rateLimits.requests())
			requestWeightLimiter = RateLimiter(rateLimits.weight())
			enable()
		} catch (e: ApiException) {
			e.printStackTrace()
			exitProcess(0)
		}
	}
	
	companion object {
		/** Singleton */
		private lateinit var rateLimiting: RateLimiting
		
		/** @return The cached instance. */
		@JvmStatic
		operator fun invoke(): RateLimiting {
			if (!::rateLimiting.isInitialized) rateLimiting = RateLimiting()
			return rateLimiting
		}
	}
}