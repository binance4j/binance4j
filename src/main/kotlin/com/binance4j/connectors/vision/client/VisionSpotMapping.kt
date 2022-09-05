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

package com.binance4j.connectors.vision.client

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/** The API SPOT calls  */
interface VisionSpotMapping {
	/**
	 * Mapping of the monthly candlestick data call
	 *
	 * @param symbol              Trading pair.
	 * @param candlestickInterval Interval between two candles.
	 * @param year                Year.
	 * @param month               Month.
	 * @return The retrofit call.
	 */
	@GET(MONTHLY_KLINES_URL)
	fun getMonthlyKlines(
		@Path("symbol") symbol: String,
		@Path("candlestick_interval") candlestickInterval: String, @Path("year") year: String,
		@Path("month") month: String
	): Call<ResponseBody>
	
	/**
	 * Mapping of the monthly candlestick data checksum call
	 *
	 * @param symbol              Trading pair.
	 * @param candlestickInterval Interval between two candles.
	 * @param year                Year.
	 * @param month               Month.
	 * @return The retrofit call.
	 */
	@GET("$MONTHLY_KLINES_URL.CHECKSUM")
	fun getMonthlyKlinesChecksum(
		@Path("symbol") symbol: String,
		@Path("candlestick_interval") candlestickInterval: String,
		@Path("year") year: String, @Path("month") month: String
	): Call<ResponseBody>
	
	/**
	 * Mapping of the daily candlestick data call
	 *
	 * @param symbol              Trading pair.
	 * @param candlestickInterval Interval between two candles.
	 * @param year                Year.
	 * @param month               Month.
	 * @param day                 Day.
	 * @return The retrofit call.
	 */
	@GET(DAILY_KLINES_URL)
	fun getDailyKlines(
		@Path("symbol") symbol: String,
		@Path("candlestick_interval") candlestickInterval: String, @Path("year") year: String,
		@Path("month") month: String, @Path("day") day: String
	): Call<ResponseBody>
	
	/**
	 * Mapping of the daily candlestick data checksum call
	 *
	 * @param symbol              Trading pair.
	 * @param candlestickInterval Interval between two candles.
	 * @param year                Year.
	 * @param month               Month.
	 * @param day                 Day.
	 * @return The retrofit call.
	 */
	@GET("$DAILY_KLINES_URL.CHECKSUM")
	fun getDailyKlinesChecksum(
		@Path("symbol") symbol: String,
		@Path("candlestick_interval") candlestickInterval: String,
		@Path("year") year: String, @Path("month") month: String, @Path("day") day: String
	): Call<ResponseBody>
	// Trades
	/**
	 * Mapping of the monthly trades call
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @return The retrofit call.
	 */
	@GET(MONTHLY_TRADES_URL)
	fun getMonthlyTrades(
		@Path("symbol") symbol: String, @Path("year") year: String,
		@Path("month") month: String
	): Call<ResponseBody>
	
	/**
	 * Mapping of the monthly trades checksum call
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @return The retrofit call.
	 */
	@GET("$MONTHLY_TRADES_URL.CHECKSUM")
	fun getMonthlyTradesChecksum(
		@Path("symbol") symbol: String, @Path("year") year: String,
		@Path("month") month: String
	): Call<ResponseBody>
	
	/**
	 * Mapping of the daily trades call
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @param day    Day.
	 * @return The retrofit call.
	 */
	@GET(DAILY_TRADES_URL)
	fun getDailyTrades(
		@Path("symbol") symbol: String, @Path("year") year: String,
		@Path("month") month: String, @Path("day") day: String
	): Call<ResponseBody>
	
	/**
	 * Mapping of the daily trades checksum call
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @param day    Day.
	 * @return The retrofit call.
	 */
	@GET("$DAILY_TRADES_URL.CHECKSUM")
	fun getDailyTradesChecksum(
		@Path("symbol") symbol: String, @Path("year") year: String,
		@Path("month") month: String, @Path("day") day: String
	): Call<ResponseBody>
	// AggTrades
	/**
	 * Mapping of the monthly aggTrades call
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @return The retrofit call.
	 */
	@GET(MONTHLY_AGGTRADES_URL)
	fun getMonthlyAggTrades(
		@Path("symbol") symbol: String, @Path("year") year: String,
		@Path("month") month: String
	): Call<ResponseBody>
	
	/**
	 * Mapping of the monthly aggTrades checksum call
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @return The retrofit call.
	 */
	@GET("$MONTHLY_AGGTRADES_URL.CHECKSUM")
	fun getMonthlyAggTradesChecksum(
		@Path("symbol") symbol: String, @Path("year") year: String,
		@Path("month") month: String
	): Call<ResponseBody>
	
	/**
	 * Mapping of the daily aggTrades call
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @param day    Day.
	 * @return The retrofit call.
	 */
	@GET(DAILY_AGGTRADES_URL)
	fun getDailyAggTrades(
		@Path("symbol") symbol: String, @Path("year") year: String,
		@Path("month") month: String, @Path("day") day: String
	): Call<ResponseBody>
	
	/**
	 * Mapping of the daily aggTrades checksum call
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @param day    Day.
	 * @return The retrofit call.
	 */
	@GET("$DAILY_AGGTRADES_URL.CHECKSUM")
	fun getDailyAggTradesChecksum(
		@Path("symbol") symbol: String, @Path("year") year: String,
		@Path("month") month: String,
		@Path("day") day: String
	): Call<ResponseBody>
	
	companion object {
		/** monthly klines url  */
		const val MONTHLY_KLINES_URL =
			"spot/monthly/klines/{symbol}/{candlestick_interval}/{symbol}-{candlestick_interval}-{year}-{month}.zip"
		
		/** daily klines url  */
		const val DAILY_KLINES_URL =
			"spot/daily/klines/{symbol}/{candlestick_interval}/{symbol}-{candlestick_interval}-{year}-{month}-{day}.zip"
		
		/** monthly trades url  */
		const val MONTHLY_TRADES_URL = "spot/monthly/trades/{symbol}/{symbol}-trades-{year}-{month}.zip"
		
		/** daily trades url  */
		const val DAILY_TRADES_URL = "spot/daily/trades/{symbol}/{symbol}-trades-{year}-{month}-{day}.zip"
		
		/** monthly agg trades url  */
		const val MONTHLY_AGGTRADES_URL = "spot/monthly/aggTrades/{symbol}/{symbol}-aggTrades-{year}-{month}.zip"
		
		/** daily agg trades url  */
		const val DAILY_AGGTRADES_URL = "spot/daily/aggTrades/{symbol}/{symbol}-aggTrades-{year}-{month}-{day}.zip"
	}
}