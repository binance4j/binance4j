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
package com.binance4j.connectors.core.ratelimiter

import com.binance4j.connectors.Connectors
import com.binance4j.connectors.core.client.RateLimits
import com.binance4j.connectors.core.exception.ApiException
import kotlin.system.exitProcess

/**
 * Wrapper for all rate limiters
 */
object RateLimiting {

    var rawRequestLimiter: RateLimiter

    var requestWeightLimiter: RateLimiter

    private var rateLimits: RateLimits

    /** Is Rate limit enabled? */
    private var enabled: Boolean = false

    /** @return if is rate limiting enabled */
    fun isEnabled() = enabled

    /** Enables global rate limiting. */
    fun enable() {
        enabled = true
    }

    /** Disables global rate limiting. */
    fun disable() {
        enabled = false
    }

    /**
     * Fetches rate limits and creates instance of rate limiters
     */
    init {
        // Fetch rate limit data
        try {
            disable()
            // init raw request and request weight limiter with data
            rateLimits = RateLimits(Connectors.rest.market.getExchangeInfo().sync().rateLimits)
            rawRequestLimiter = RateLimiter(rateLimits.rawRequestsLimit)
            requestWeightLimiter = RateLimiter(rateLimits.weightLimit)
            enable()
        } catch (e: ApiException) {
            e.printStackTrace()
            exitProcess(0)
        }
    }
}