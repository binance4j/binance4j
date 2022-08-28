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
import kotlin.math.floor
import kotlin.math.max

/**
 * Rate limiter.
 * @param rateLimit The rateLimit to calculate limit per second.
 */
class RateLimiter(rateLimit: RateLimit?) {

    /** Points per second. */
    val rate: Int

    /** Remaining points for the period. */
    private var remaining: Int

    /** Interval event reloading points per period every second. */
    private var periodStart: Long = 0

    /** Now */
    private var now: Long = 0

    /** Next period */
    private var nextPeriod: Long = 0

    /** Time to wait before next period */
    private var wait: Long = 0

    init {
        // calculating limit per second from RateLimit instance
        val intervalInSeconds = RateLimitInterval.valueOf(rateLimit?.interval!!).value * rateLimit.intervalNum!!
        rate = floor((rateLimit.limit!! / intervalInSeconds).toDouble()).toInt()
        remaining = rate
    }

    /**
     * Acquires the given number of points from this RateLimiter, blocking until
     * the request can be granted.
     *
     * @param points The points to remove.
     * @return time spent sleeping to enforce rate, in ms; 0 if not rate-limited.
     */
    fun acquire(points: Int): Long {
        now = System.currentTimeMillis()
        remaining = max(0, remaining - points)

        if (periodStart == 0L) {
            periodStart = now
        }

        nextPeriod = periodStart + 1000

        if (remaining <= 0) {
            try {
                wait = max(0, nextPeriod - now)
                // sleep till next period
                Thread.sleep(wait)
                now = System.currentTimeMillis()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        } else {
            wait = 0
        }

        // resetting values if period is exceeded
        if (now >= nextPeriod) {
            resetValues()
        }
        return wait
    }

    private fun resetValues() {
        remaining = rate
        periodStart = now
    }
}