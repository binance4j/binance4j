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

package com.binance4j.connectors.websocket.service

import com.binance4j.connectors.core.dto.CandlestickInterval
import java.time.Duration

/** Service for converting data into a duration  */
object DurationService {
    /**
     * Converts a candlestick interval into a duration
     *
     * @param interval Candlestick interval.
     * @return The corresponding duration.
     */
    @JvmStatic
    fun convert(interval: CandlestickInterval?): Duration {
        return when (interval) {
            CandlestickInterval.DAILY -> Duration.ofDays(1)
            CandlestickInterval.EIGHT_HOURLY -> Duration.ofHours(8)
            CandlestickInterval.FIFTEEN_MINUTES -> Duration.ofMinutes(15)
            CandlestickInterval.FIVE_MINUTES -> Duration.ofMinutes(5)
            CandlestickInterval.FOUR_HOURLY -> Duration.ofHours(4)
            CandlestickInterval.HALF_HOURLY -> Duration.ofMinutes(30)
            CandlestickInterval.HOURLY -> Duration.ofHours(1)
            CandlestickInterval.MONTHLY_MARKET, CandlestickInterval.MONTHLY_VISION -> Duration.ofDays(30)
            CandlestickInterval.ONE_MINUTE -> Duration.ofMinutes(1)
            CandlestickInterval.SIX_HOURLY -> Duration.ofHours(6)
            CandlestickInterval.THREE_DAILY -> Duration.ofDays(3)
            CandlestickInterval.THREE_MINUTES -> Duration.ofMinutes(3)
            CandlestickInterval.TWELVE_HOURLY -> Duration.ofHours(12)
            CandlestickInterval.TWO_HOURLY -> Duration.ofHours(2)
            CandlestickInterval.WEEKLY -> Duration.ofDays(7)
            else -> Duration.ZERO
        }
    }
}