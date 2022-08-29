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

package com.binance4j.market.client;

import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.core.test.CustomTest;
import com.binance4j.market.dto.OrderBookLimit;
import com.binance4j.market.param.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class MarketClientTest extends CustomTest {
    MarketClient client = new MarketClient(key, secret);

    public MarketClientTest() {
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
    }

    @Test
    void testGet24hTickerStatistics() throws ApiException {
        testNotThrow(client.get24hTickerStatistics());
    }

    @Test
    void testGet24hTickerStatistics2() throws ApiException {
        testNotThrow(client.get24hTickerStatistics(new TickerStatisticsParams(symbol)));
    }

    @Test
    void testGet24hTickerStatistics3() throws ApiException {
        testNotThrow(client.get24hTickerStatistics(new TickersStatisticsParams(symbols)));
    }

    @Test
    void testGetAggTrades() throws ApiException {
        testNotThrow(client.getAggTrades(new AggTradeParams(symbol)));
    }

    @Test
    void testGetAggTrades2() throws ApiException {
        testNotThrow(client.getAggTrades(new AggTradeParams(symbol), new TimeFrame(limit)));
    }

    @Test
    void testGetAggTrades3() throws ApiException {
        testNotThrow(
                client.getAggTrades(new AggTradeParams(symbol), new TimeFrame(1640991600000L, 1640994900000L)));
    }

    @Test
    void testGetAggTrades4() throws ApiException {
        testNotThrow(client.getAggTrades(new AggTradeParams(symbol, 244397449L)));
    }

    @Test
    void testGetAveragePrice() throws ApiException {
        testNotThrow(client.getAveragePrice(new AveragePriceParams(symbol)));
    }

    @Test
    void testGetBookTicker() throws ApiException {
        testNotThrow(client.getBookTicker());
    }

    @Test
    void testGetBookTicker2() throws ApiException {
        testNotThrow(client.getBookTicker(new BookTickerParams(symbol)));
    }

    @Test
    void testGetBookTicker3() throws ApiException {
        testNotThrow(client.getBookTicker(new BookTickersParams(symbols)));
    }

    @Test
    void testGetExchangeInfo() throws ApiException {
        testNotThrow(client.getExchangeInfo());
    }

    @Test
    void testGetExchangeInfo2() throws ApiException {
        testNotThrow(client.getExchangeInfo(new ExchangeInfoParams(symbol)));
    }

    @Test
    void testGetHistoricalTrades() throws ApiException {
        testNotThrow(client.getHistoricalTrades(new HistoricalTradesParams(symbol)));
    }

    @Test
    void testGetHistoricalTrades2() throws ApiException {
        testNotThrow(client.getHistoricalTrades(new HistoricalTradesParams(symbol, limit)));
    }

    @Test
    void testGetHistoricalTrades3() throws ApiException {
        testNotThrow(client.getHistoricalTrades(new HistoricalTradesParams(symbol, 186647289L)));
    }

    @Test
    void testGetHistoricalTrades4() throws ApiException {
        testNotThrow(client.getHistoricalTrades(new HistoricalTradesParams(symbol, limit, 186647289L)));
    }

    @Test
    void testGetKlines() throws ApiException {
        List<CandlestickInterval> intervals = new LinkedList<>(List.of(CandlestickInterval.values()));
        intervals.remove(CandlestickInterval.MONTHLY_VISION);
        for (CandlestickInterval interval : intervals) {
            KlinesParams params = new KlinesParams(symbol, interval);
            testNotThrow(client.getKlines(params));
        }
    }

    @Test
    void testGetKlines2() throws ApiException {
        testNotThrow(client.getKlines(new KlinesParams(symbol, CandlestickInterval.HOURLY), new TimeFrame(limit)));
    }

    @Test
    void testGetOrderBook() throws ApiException {
        testNotThrow(client.getOrderBook(new OrderBookParams(symbol)));
    }

    @Test
    void testGetOrderBook2() throws ApiException {
        testNotThrow(client.getOrderBook(new OrderBookParams(symbol, OrderBookLimit.LIMIT_10)));
    }

    @Test
    void testGetServerTime() throws ApiException {
        testNotThrow(client.getServerTime());
    }

    @Test
    void testGetTicker() throws ApiException {
        testNotThrow(client.getTicker());
    }

    @Test
    void testGetTicker2() throws ApiException {
        testNotThrow(client.getTicker(new PriceTickerParams(symbol)));
    }

    @Test
    void testGetTicker3() throws ApiException {
        testNotThrow(client.getTicker(new PriceTickersParams(symbols)));
    }

    @Test
    void testGetTrades() throws ApiException {
        testNotThrow(client.getTrades(new TradesParams(symbol)));
    }

    @Test
    void testGetTrades2() throws ApiException {
        testNotThrow(client.getTrades(new TradesParams(symbol, limit)));
    }

    @Test
    void testPing() throws ApiException {
        testNotThrow(client.ping());
    }
}
