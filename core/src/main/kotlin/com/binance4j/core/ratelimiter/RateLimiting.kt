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

import com.binance4j.core.client.RateLimitClient
import com.binance4j.core.client.RateLimits
import com.binance4j.core.exception.ApiException

/**
 * Wrapper for all rate limiters
 */
class RateLimiting {
    private val rateLimitClient = RateLimitClient()
    private lateinit var rawRequestLimiter: RateLimiter
    private lateinit var requestWeightLimiter: RateLimiter
    private lateinit var rateLimits: RateLimits

    /**
     * Fetches rate limits and creates instance of rate limiters
     */
    init {
        // Fetch rate limit data
        try {
            disable()
            rateLimits = rateLimitClient.rateLimits.sync()
            // init raw request limiter with data
            rawRequestLimiter = RateLimiter(rateLimits.requests())
            // init request weight limiter with data
            requestWeightLimiter = RateLimiter(rateLimits.weight())
            enable()
        } catch (e: ApiException) {
            e.printStackTrace()
            System.exit(0)
        }
    }

    /**
     * @return the requestWeightLimiter
     */
    fun weight(): RateLimiter {
        return requestWeightLimiter
    }

    /**
     * @return the rawRequestLimiter
     */
    fun raw(): RateLimiter {
        return rawRequestLimiter
    }

    companion object {
        /**
         * @return if rate limiting is enabled.
         */
        var isEnabled = true
            private set

        /**
         * Enables global rate limiting.
         */
        fun enable() {
            isEnabled = true
        }

        /**
         * Disables global rate limiting.
         */
        fun disable() {
            isEnabled = false
        }
        // static
    }
}