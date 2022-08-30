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

import com.binance4j.core.Binance4j
import com.binance4j.core.dto.CandlestickInterval
import com.binance4j.core.exception.ApiException
import com.binance4j.core.test.CustomTest
import com.binance4j.market.param.*
import com.fasterxml.jackson.databind.DeserializationFeature
import org.junit.jupiter.api.Test
import java.util.*

class MarketClientTest : CustomTest() {
	var client = MarketClient(key, secret)
	
	init {
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGet24hTickerStatistics() {
		assertNotThrow(client.get24hTickerStatistics())
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGet24hTickerStatistics2() {
		assertNotThrow(client.get24hTickerStatistics(TickerStatisticsParams(symbol)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGet24hTickerStatistics3() {
		assertNotThrow(client.get24hTickerStatistics(TickersStatisticsParams(symbols)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetAggTrades() {
		assertNotThrow(client.getAggTrades(AggTradeParams(symbol)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetAggTrades2() {
		assertNotThrow(client.getAggTrades(AggTradeParams(symbol, limit = limit)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetAggTrades3() {
		assertNotThrow(
			client.getAggTrades(AggTradeParams(symbol, null, 1640991600000L, 1640994900000L))
		)
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetAggTrades4() {
		assertNotThrow(client.getAggTrades(AggTradeParams(symbol, 244397449L)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetAveragePrice() {
		assertNotThrow(client.getAveragePrice(AveragePriceParams(symbol)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetBookTicker() {
		assertNotThrow(client.getBookTicker())
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetBookTicker2() {
		assertNotThrow(client.getBookTicker(BookTickerParams(symbol)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetBookTicker3() {
		assertNotThrow(client.getBookTicker(BookTickersParams(symbols)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetExchangeInfo() {
		assertNotThrow(client.getExchangeInfo())
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetExchangeInfo2() {
		assertNotThrow(client.getExchangeInfo(ExchangeInfoParams(symbol)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetHistoricalTrades() {
		assertNotThrow(client.getHistoricalTrades(HistoricalTradesParams(symbol)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetHistoricalTrades2() {
		assertNotThrow(client.getHistoricalTrades(HistoricalTradesParams(symbol, limit)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetHistoricalTrades3() {
		assertNotThrow(client.getHistoricalTrades(HistoricalTradesParams(symbol, 186647289L.toInt())))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetHistoricalTrades4() {
		assertNotThrow(client.getHistoricalTrades(HistoricalTradesParams(symbol, limit, 186647289L)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetKlines() {
		val intervals: MutableList<CandlestickInterval> = LinkedList(listOf(*CandlestickInterval.values()))
		intervals.remove(CandlestickInterval.MONTHLY_VISION)
		for (interval in intervals) {
			assertNotThrow(client.getKlines(KlinesParams(symbol, interval)))
		}
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetKlines2() {
		assertNotThrow(client.getKlines(KlinesParams(symbol, CandlestickInterval.HOURLY, limit = limit)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetOrderBook() {
		assertNotThrow(client.getOrderBook(OrderBookParams(symbol)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetOrderBook2() {
		assertNotThrow(client.getOrderBook(OrderBookParams(symbol, 10)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetServerTime() {
		assertNotThrow(client.getServerTime())
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetTicker() {
		assertNotThrow(client.getTicker())
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetTicker2() {
		assertNotThrow(client.getTicker(PriceTickerParams(symbol)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetTicker3() {
		assertNotThrow(client.getTicker(PriceTickersParams(symbols)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetTrades() {
		assertNotThrow(client.getTrades(TradesParams(symbol)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testGetTrades2() {
		assertNotThrow(client.getTrades(TradesParams(symbol, limit)))
	}
	
	@Test
	@Throws(ApiException::class)
	fun testPing() {
		assertNotThrow(client.ping())
	}
}