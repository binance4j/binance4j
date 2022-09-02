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

package com.binance4j.core.dto

/**
 * Kline/Candlestick intervals. m : minutes; h : hours; d : days; w : weeks; M : months
 * @property value Value
 */
enum class CandlestickInterval(var value: String) {
	/** 1 minute interval.  */
	ONE_MINUTE("1m"),
	
	/** 3 minutes interval.  */
	THREE_MINUTES("3m"),
	
	/** 5 minutes interval.  */
	FIVE_MINUTES("5m"),
	
	/** 15 minutes interval.  */
	FIFTEEN_MINUTES("15m"),
	
	/** 30 minutes interval.  */
	HALF_HOURLY("30m"),
	
	/** 1 hour interval.  */
	HOURLY("1h"),
	
	/** 2 hours interval.  */
	TWO_HOURLY("2h"),
	
	/** 4 hours interval.  */
	FOUR_HOURLY("4h"),
	
	/** 6 hours interval.  */
	SIX_HOURLY("6h"),
	
	/** 8 hours interval.  */
	EIGHT_HOURLY("8h"),
	
	/** 12 hours interval.  */
	TWELVE_HOURLY("12h"),
	
	/** 1 day interval.  */
	DAILY("1d"),
	
	/** 3 days interval.  */
	THREE_DAILY("3d"),
	
	/** 1 week interval.  */
	WEEKLY("1w"),
	
	/** 1-month intervar for market data.  */
	MONTHLY_MARKET("1M"),
	
	/** 1-month intervar for vision data.  */
	MONTHLY_VISION("1mo");
	
	override fun toString(): String = value
	
	companion object {
		/**
		 * @property value The intervar String value.
		 * @return The enum equivalent of the input value.
		 */
		@JvmStatic
		fun fromValue(value: String): CandlestickInterval? {
			for (e in values()) {
				if (e.toString() == value) return e
			}
			return null
		}
	}
}