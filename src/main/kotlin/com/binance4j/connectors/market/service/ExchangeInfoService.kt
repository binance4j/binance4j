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

package com.binance4j.connectors.market.service

import com.binance4j.connectors.Connectors
import com.binance4j.connectors.core.service.CacheControlService
import com.binance4j.connectors.market.dto.ExchangeInfo
import com.binance4j.connectors.market.dto.SymbolInfo

/** Manipulates exchange info data */
object ExchangeInfoService {

    /** A cached version of the exchange info */
    private val exchangeInfo: ExchangeInfo
        get() = CacheService.data

    /**
     * @param symbol Symbol to check.
     *
     * @return The existence of the symbol's [SymbolInfo] in the [ExchangeInfo].
     */
    fun symbolExists(symbol: String): Boolean = getSymbolInfo(symbol) != null

    /**
     * @param symbol Symbol we want the info.
     * @param symbols List of symbols info to search in.
     *
     * @return The symbol info in the given list of symbol info.
     */
    @JvmStatic
    fun getSymbolInfo(symbol: String, symbols: List<SymbolInfo>): SymbolInfo? = symbols.filter { symbolInfo -> symbolInfo.symbol == symbol }.getOrNull(0)

    /**
     * Fetches the exchange info and returns the symbol info.
     *
     * @param symbol Symbol we want the info.
     * @return The symbol info in the given list.
     */
    @JvmStatic
    fun getSymbolInfo(symbol: String): SymbolInfo? = getSymbolInfo(symbol, exchangeInfo.symbols)

    /**
     * @param symbol Symbol we want the info service.
     * @param symbols List of symbols info to search in.
     *
     * @return A [SymbolInfoService] containing additional data about the symbol.
     */
    @JvmStatic
    fun getSymbolInfoService(symbol: String, symbols: List<SymbolInfo>): SymbolInfoService? = getSymbolInfo(symbol, symbols)?.let { SymbolInfoService(it) }

    /**
     * Fetches the exchange info and returns a symbol info service containing additional data about the symbol.
     *
     * @param symbol Symbol we want the info service.
     * @return A [SymbolInfoService] containing additional data about the symbol.
     */
    @JvmStatic
    fun getSymbolInfoService(symbol: String): SymbolInfoService? = getSymbolInfo(symbol)?.let { SymbolInfoService(it) }

    /**
     * Internal cache service.
     */
    object CacheService : CacheControlService<ExchangeInfo>() {
        override fun fetchData(): ExchangeInfo = Connectors.rest.market.getExchangeInfo().sync()
    }
}