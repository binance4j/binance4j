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

package com.binance4j.connectors.market.client

import com.binance4j.connectors.core.Headers.API_H
import com.binance4j.connectors.core.Headers.IP_H
import com.binance4j.connectors.core.Headers.NO_RECV_WINDOW_H
import com.binance4j.connectors.core.Headers.NO_TIMESTAMP_H
import com.binance4j.connectors.core.Headers.WEIGHT_ONE_H
import com.binance4j.connectors.core.dto.AggTrade
import com.binance4j.connectors.core.dto.Candle
import com.binance4j.connectors.market.dto.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/** [MarketClient] mapping.  */
interface MarketMapping {
    /**
     * @return The generated Retrofit call.
     */
    @GET("/api/v3/ping")
    @Headers(IP_H, WEIGHT_ONE_H, NO_RECV_WINDOW_H, NO_TIMESTAMP_H)
    fun ping(): Call<Unit>

    /**
     * @return The generated Retrofit call.
     */
    @GET("/api/v3/time")
    @Headers(IP_H, WEIGHT_ONE_H, NO_RECV_WINDOW_H, NO_TIMESTAMP_H)
    fun getServerTime(): Call<ServerTimeResponse>

    /**
     * Get current exchange trading rules and multiple symbols info.
     *
     * @param symbols Symbols.
     *
     * @return The generated Retrofit call.
     */
    @GET("/api/v3/exchangeInfo")
    @Headers(IP_H, "X-WEIGHT: 10", NO_RECV_WINDOW_H, NO_TIMESTAMP_H)
    fun getExchangeInfos(@Query("symbols") symbols: String?): Call<ExchangeInfo>

    /**
     * Get current exchange trading rules and one symbol info.
     *
     * @param symbol Symbol.
     *
     * @return The generated Retrofit call.
     */
    @GET("/api/v3/exchangeInfo")
    @Headers(IP_H, "X-WEIGHT: 10", NO_RECV_WINDOW_H, NO_TIMESTAMP_H)
    fun getExchangeInfo(@Query("symbol") symbol: String): Call<ExchangeInfo>

    /**
     * Get the symbol order book.
     *
     * @param symbol Trading pair we want the depth.
     * @param limit  Market depth size.
     *
     * @return The generated Retrofit call.
     */
    @GET("/api/v3/depth")
    @Headers(IP_H, "X-WEIGHT: 50", NO_RECV_WINDOW_H, NO_TIMESTAMP_H)
    fun getOrderBook(@Query("symbol") symbol: String, @Query("limit") limit: Int?): Call<OrderBook>

    /**
     * Get recent trades.
     *
     * @param symbol Symbol we want the trades.
     * @param limit  Trades size.
     *
     * @return The generated Retrofit call.
     */
    @GET("/api/v3/trades")
    @Headers(IP_H, WEIGHT_ONE_H, NO_RECV_WINDOW_H, NO_TIMESTAMP_H)
    fun getTrades(@Query("symbol") symbol: String, @Query("limit") limit: Int?): Call<List<Trade>>

    /**
     * Get older market trades.
     *
     * @param symbol Trading pair to get the trades.
     * @param limit  Default 500; max 1000.
     * @param fromId Trade id to fetch from. Default gets most recent trades.
     *
     * @return The generated Retrofit call.
     */
    @GET("/api/v3/historicalTrades")
    @Headers(API_H, IP_H, "X-WEIGHT: 5", NO_RECV_WINDOW_H, NO_TIMESTAMP_H)
    fun getHistoricalTrades(@Query("symbol") symbol: String, @Query("limit") limit: Int?, @Query("fromId") fromId: Long?): Call<List<Trade>>

    /**
     * Get compressed, aggregate trades.
     *
     * @param symbol    Symbol.
     * @param fromId    ID to get aggregate trades from (inclusive).
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param limit     Results limit.
     *
     * @return The generated Retrofit call.
     */
    @GET("/api/v3/aggTrades")
    @Headers(IP_H, WEIGHT_ONE_H, NO_RECV_WINDOW_H, NO_TIMESTAMP_H)
    fun getAggTrades(
        @Query("symbol") symbol: String,
        @Query("fromId") fromId: Long?,
        @Query("startTime") startTime: Long?,
        @Query("endTime") endTime: Long?,
        @Query("limit") limit: Int?
    ): Call<List<AggTrade>>

    /**
     * Kline/candles for a symbol.
     *
     * @param symbol    Trading pair we want the data.
     * @param interval  Candlestick interval.
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param limit     Results limit.
     *
     * @return The generated Retrofit call.
     */
    @GET("/api/v3/klines")
    @Headers(IP_H, WEIGHT_ONE_H, NO_RECV_WINDOW_H, NO_TIMESTAMP_H)
    fun getKlines(
        @Query("symbol") symbol: String,
        @Query("interval") interval: String,
        @Query("startTime") startTime: Long?,
        @Query("endTime") endTime: Long?,
        @Query("limit") limit: Int?
    ): Call<List<Candle>>

    /**
     * Get Current average price for a symbol.
     *
     * @param symbol Trading pair we want the price.
     *
     * @return The generated Retrofit call.
     */
    @GET("/api/v3/avgPrice")
    @Headers(IP_H, WEIGHT_ONE_H, NO_RECV_WINDOW_H, NO_TIMESTAMP_H)
    fun getAveragePrice(@Query("symbol") symbol: String): Call<AveragePrice>

    /**
     * Latest price for multiple symbols.
     *
     * @param symbols Symbols. Format: '["BTCBUSD","BNBBUSD"]'
     *
     * @return The generated Retrofit call.
     */
    @GET("/api/v3/ticker/24hr")
    @Headers(IP_H, "X-WEIGHT: 40", NO_RECV_WINDOW_H, NO_TIMESTAMP_H)
    fun get24hTickers(@Query("symbols") symbols: String?): Call<List<TickerStatistics>>

    /**
     * Get 24-hour rolling window price change statistics of a symbol.
     *
     * @param symbol Symbol.
     *
     * @return The generated Retrofit call.
     */
    @GET("/api/v3/ticker/24hr")
    @Headers(IP_H, "X-WEIGHT: 40", NO_RECV_WINDOW_H, NO_TIMESTAMP_H)
    fun get24hTicker(@Query("symbol") symbol: String): Call<TickerStatistics>

    /**
     * Latest price for one symbol.
     *
     * @param symbol Symbol.
     *
     * @return The generated Retrofit call.
     */
    @GET("/api/v3/ticker/price")
    @Headers(IP_H, "X-WEIGHT: 2", NO_RECV_WINDOW_H, NO_TIMESTAMP_H)
    fun getTicker(@Query("symbol") symbol: String): Call<PriceTicker>

    /**
     * Latest price for multiple symbols.
     *
     * @param symbols Symbols.
     *
     * @return The generated Retrofit call.
     */
    @GET("/api/v3/ticker/price")
    @Headers(IP_H, "X-WEIGHT: 2", NO_RECV_WINDOW_H, NO_TIMESTAMP_H)
    fun getTickers(@Query("symbols") symbols: String?): Call<List<PriceTicker>>

    /**
     * Get best price/quantity on the order book for the given symbols.
     *
     * @param symbol Symbol.
     *
     * @return The generated Retrofit call.
     */
    @GET("/api/v3/ticker/bookTicker")
    @Headers(IP_H, "X-WEIGHT: 2", NO_RECV_WINDOW_H, NO_TIMESTAMP_H)
    fun getBookTicker(@Query("symbol") symbol: String): Call<BookTicker>

    /**
     * Get best price/quantity on the order book for multiple symbols.
     *
     * @param symbols Symbols.
     *
     * @return The generated Retrofit call.
     */
    @GET("/api/v3/ticker/bookTicker")
    @Headers(IP_H, "X-WEIGHT: 2", NO_RECV_WINDOW_H, NO_TIMESTAMP_H)
    fun getBookTickers(@Query("symbols") symbols: String?): Call<List<BookTicker>>
}