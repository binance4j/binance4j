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

import com.binance4j.core.Request
import com.binance4j.core.client.RestClient
import com.binance4j.market.param.*

/**
 * API client for the market endpoints
 *
 * [Documentation](https://binance-docs.github.io/apidocs/spot/en/#market-data-endpoints)
 */
class MarketClient
/**
 * @param key    API public key.
 * @param secret API secret key.
 */
	(key: String, secret: String) : RestClient<MarketMapping>(MarketMapping::class.java, key, secret) {
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
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getExchangeInfo(params: ExchangeInfoParams = ExchangeInfoParams()) =
		Request(service.getExchangeInfo(params.toMap()))
	
	/**
	 * Get the symbol order book.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getOrderBook(params: OrderBookParams) = Request(service.getOrderBook(params.toMap()))
	
	/**
	 * Get recent trades.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getTrades(params: TradesParams) = Request(service.getTrades(params.toMap()))
	
	/**
	 * Get older market trades.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getHistoricalTrades(params: HistoricalTradesParams) = Request(service.getHistoricalTrades(params.toMap()))
	
	/**
	 * Get compressed, aggregate trades.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getAggTrades(params: AggTradeParams) = Request(service.getAggTrades(params.toMap()))
	
	/**
	 * Kline/candles for a symbol.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getKlines(params: KlinesParams) = Request(service.getKlines(params.toMap()))
	
	/**
	 * Get Current average price for a symbol.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getAveragePrice(params: AveragePriceParams) = Request(service.getAveragePrice(params.toMap()))
	
	/**
	 * Get 24-hour rolling window price change statistics of a symbol.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun get24hTickerStatistics(params: TickerStatisticsParams) = Request(service.get24hTickerStatistics(params.toMap()))
	
	/**
	 * Get 24-hour rolling window price change statistics of all symbols.
	 *
	 * @return The request to execute.
	 */
	fun get24hTickerStatistics() = Request(service.get24hTickerStatistics())
	
	/**
	 * Get 24-hour rolling window price change statistics of specific symbols.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun get24hTickerStatistics(params: TickersStatisticsParams) =
		Request(service.get24hTickersStatistics(params.toMap()))
	
	/**
	 * Latest price for all symbols.
	 *
	 * @return The request to execute.
	 */
	fun getTicker() = Request(service.getTicker())
	
	/**
	 * Latest price for a symbol or symbols.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getTicker(params: PriceTickerParams) = Request(service.getTicker(params.toMap()))
	
	/**
	 * Latest price for a symbol or symbols.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getTicker(params: PriceTickersParams) = Request(service.getTickers(params.toMap()))
	
	/**
	 * Get best price/quantity on the order book for a symbol.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getBookTicker(params: BookTickerParams) = Request(service.getBookTicker(params.toMap()))
	
	/**
	 * Get best price/quantity on the order book for all symbols.
	 *
	 * @return The request to execute.
	 */
	fun getBookTicker() = Request(service.getBookTicker())
	
	/**
	 * Get best price/quantity on the order book for the given symbols.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getBookTicker(params: BookTickersParams) = Request(service.getBookTickers(params.toMap()))
}