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

import com.binance4j.connectors.core.Request
import com.binance4j.connectors.core.client.RestClient
import com.binance4j.connectors.core.dto.CandlestickInterval

/**
 * API client for the market endpoints
 *
 * [Documentation](https://binance-docs.github.io/apidocs/spot/en/#market-data-endpoints)
 */
object MarketClient : RestClient<MarketMapping>(MarketMapping::class.java) {
    /**
     * Test connectivity to the Rest API.
     *
     * @return The request to execute.
     */
    fun ping() = Request(service.ping())

    /**
     * Test connectivity to the Rest API and get the current server time.
     *
     * @return The request to execute.
     */
    fun getServerTime() = Request(service.getServerTime())

    /**
     * Get current exchange trading rules and one or many symbols info.
     *
     * @param symbol Symbol.
     *
     * @return The request to execute.
     */
    fun getExchangeInfo(symbol: String) = Request(service.getExchangeInfo(symbol))

    /**
     * Get current exchange trading rules and one or many symbols info.
     *
     * @param symbols Symbols.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getExchangeInfo(symbols: List<String>? = null) = Request(service.getExchangeInfos(if (symbols != null) joinSymbols(symbols) else null))

    /**
     * Get the symbol order book.
     *
     * @param symbol Trading pair we want the depth.
     * @param limit  Market depth size.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getOrderBook(symbol: String, limit: Int? = null) = Request(service.getOrderBook(symbol, limit))

    /**
     * Get recent trades.
     *
     * @param symbol Symbol we want the trades.
     * @param limit  Trades size.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getTrades(symbol: String, limit: Int? = null) = Request(service.getTrades(symbol, limit))

    /**
     * Get older market trades.
     *
     * @param symbol Trading pair to get the trades.
     * @param limit  Default 500; max 1000.
     * @param fromId Trade id to fetch from. Default gets most recent trades.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getHistoricalTrades(symbol: String, limit: Int? = null, fromId: Long? = null) = Request(service.getHistoricalTrades(symbol, limit, fromId))

    /**
     * Get compressed, aggregate trades.
     *
     * @param symbol    Symbol.
     * @param fromId    ID to get aggregate trades from (inclusive).
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param limit     Results limit.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getAggTrades(symbol: String, fromId: Long? = null, startTime: Long? = null, endTime: Long? = null, limit: Int? = null) =
        Request(service.getAggTrades(symbol, fromId, startTime, endTime, limit))

    /**
     * Kline/candles for a symbol.
     *
     * @param symbol    Trading pair we want the data.
     * @param interval  Candlestick interval.
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param limit     Results limit.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getKlines(symbol: String, interval: CandlestickInterval, startTime: Long? = null, endTime: Long? = null, limit: Int? = null) =
        Request(service.getKlines(symbol, interval.toString(), startTime, endTime, limit))

    /**
     * Get Current average price for a symbol.
     *
     * @param symbol Trading pair we want the price.
     *
     * @return The request to execute.
     */
    fun getAveragePrice(symbol: String) = Request(service.getAveragePrice(symbol))

    /**
     * Get 24-hour rolling window price change statistics of a symbol.
     *
     * @param symbol Symbol.
     *
     * @return The request to execute.
     */
    fun get24hTicker(symbol: String) = Request(service.get24hTicker(symbol))

    /**
     * Get 24-hour rolling window price change statistics of specific symbols.
     *
     * @param symbols Symbols.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun get24hTicker(symbols: List<String>? = null) = Request(service.get24hTickers(if (symbols != null) joinSymbols(symbols) else null))

    /**
     * Latest price for one or all symbols.
     *
     * @param symbol Symbol.
     *
     * @return The request to execute.
     */
    fun getTicker(symbol: String) = Request(service.getTicker(symbol))

    /**
     * Latest price for multiple symbols.
     *
     * @param symbols Symbols.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getTicker(symbols: List<String>? = null) = Request(service.getTickers(if (symbols != null) joinSymbols(symbols) else null))


    /**
     * Get best price/quantity on the order book for multiple symbols.
     *
     * @param symbols Symbols.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getBookTicker(symbols: List<String>? = null) = Request(service.getBookTickers(if (symbols != null) joinSymbols(symbols) else null))

    /**
     * Get best price/quantity on the order book for the given symbol.
     *
     * @param symbol Symbol.
     *
     * @return The request to execute.
     */
    fun getBookTicker(symbol: String) = Request(service.getBookTicker(symbol))

    /** Generates an array of symbols in a string from a list of symbols.
     *
     * @param symbols The list to wrap.
     *
     * @return An array inside a String in this format : "[\"foo\",\"bar\"]"
     * */
    private fun joinSymbols(symbols: List<String>) = "[" + symbols.joinToString(",") { s -> String.format("\"%s\"", s.trim()) } + "]"
}