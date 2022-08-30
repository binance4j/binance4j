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

package com.binance4j.market.client

import com.binance4j.core.Headers.API_H
import com.binance4j.core.Headers.IP_H
import com.binance4j.core.Headers.WEIGHT_ONE_H
import com.binance4j.core.dto.AggTrade
import com.binance4j.core.dto.Candle
import com.binance4j.market.dto.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

/** [MarketClient] mapping.  */
interface MarketMapping {
	/**
	 * @return The generated Retrofit call.
	 */
	@GET("/api/v3/ping")
	@Headers(IP_H, WEIGHT_ONE_H)
	fun ping(): Call<Void>
	
	/**
	 * @return The generated Retrofit call.
	 */
	@Headers(IP_H, WEIGHT_ONE_H)
	@GET("/api/v3/time")
	fun getServerTime(): Call<ServerTimeResponse>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET("/api/v3/exchangeInfo")
	@Headers(IP_H, "X-WEIGHT: 10")
	fun getExchangeInfo(@QueryMap map: Map<String, Any>): Call<ExchangeInfo>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET("/api/v3/depth")
	@Headers(IP_H, "X-WEIGHT: 50")
	fun getOrderBook(@QueryMap map: Map<String, Any>): Call<OrderBook>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET("/api/v3/trades")
	@Headers(IP_H, WEIGHT_ONE_H)
	fun getTrades(@QueryMap map: Map<String, Any>): Call<List<Trade>>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(API_H, IP_H, "X-WEIGHT: 5")
	@GET("/api/v3/historicalTrades")
	fun getHistoricalTrades(@QueryMap map: Map<String, Any>): Call<List<Trade>>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET("/api/v3/aggTrades")
	@Headers(IP_H, WEIGHT_ONE_H)
	fun getAggTrades(@QueryMap map: Map<String, Any>): Call<List<AggTrade>>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET("/api/v3/klines")
	@Headers(IP_H, WEIGHT_ONE_H)
	fun getKlines(@QueryMap map: Map<String, Any>): Call<List<Candle>>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET("/api/v3/avgPrice")
	@Headers(IP_H, WEIGHT_ONE_H)
	fun getAveragePrice(@QueryMap map: Map<String, Any>): Call<AveragePrice>
	
	/**
	 * @return The generated Retrofit call.
	 */
	@GET("/api/v3/ticker/24hr")
	@Headers(IP_H, "X-WEIGHT: 40")
	fun get24hTickerStatistics(): Call<List<TickerStatistics>>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET("/api/v3/ticker/24hr")
	@Headers(IP_H, "X-WEIGHT: 40")
	fun get24hTickerStatistics(@QueryMap map: Map<String, Any>): Call<TickerStatistics>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET("/api/v3/ticker/24hr")
	@Headers(IP_H, "X-WEIGHT: 40")
	fun get24hTickersStatistics(@QueryMap map: Map<String, Any>): Call<List<TickerStatistics>>
	
	/**
	 * @return The generated Retrofit call.
	 */
	@Headers(IP_H, "X-WEIGHT: 2")
	@GET("/api/v3/ticker/price")
	fun getTicker(): Call<List<PriceTicker>>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET("/api/v3/ticker/price")
	@Headers(IP_H, "X-WEIGHT: 2")
	fun getTickers(@QueryMap map: Map<String, Any>): Call<List<PriceTicker>>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET("/api/v3/ticker/price")
	@Headers(IP_H, "X-WEIGHT: 2")
	fun getTicker(@QueryMap map: Map<String, Any>): Call<PriceTicker>
	
	/**
	 * @return The generated Retrofit call.
	 */
	@Headers(IP_H, "X-WEIGHT: 2")
	@GET("/api/v3/ticker/bookTicker")
	fun getBookTicker(): Call<List<BookTicker>>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET("/api/v3/ticker/bookTicker")
	@Headers(IP_H, "X-WEIGHT: 2")
	fun getBookTicker(@QueryMap map: Map<String, Any>): Call<BookTicker>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET("/api/v3/ticker/bookTicker")
	@Headers(IP_H, "X-WEIGHT: 2")
	fun getBookTickers(@QueryMap map: Map<String, Any>): Call<List<BookTicker>>
}