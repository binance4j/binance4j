package com.binance4j.market.client;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.core.test.CustomTest;
import com.binance4j.market.dto.OrderBookLimit;
import com.binance4j.market.param.AggTradeParams;
import com.binance4j.market.param.AveragePriceParams;
import com.binance4j.market.param.BookTickerParams;
import com.binance4j.market.param.BookTickersParams;
import com.binance4j.market.param.ExchangeInfoParams;
import com.binance4j.market.param.HistoricalTradesParams;
import com.binance4j.market.param.KlinesParams;
import com.binance4j.market.param.OrderBookParams;
import com.binance4j.market.param.PriceTickerParams;
import com.binance4j.market.param.PriceTickersParams;
import com.binance4j.market.param.TickerStatisticsParams;
import com.binance4j.market.param.TickersStatisticsParams;
import com.binance4j.market.param.TradesParams;

public class MarketClientTest extends CustomTest {
	MarketClient client = new MarketClient(key, secret);

	@Override
	protected MarketClient getClient() {
		return client;
	}

	@Test
	void testGet24hTickerStatistics() throws ApiException {
		testNotThrow(getClient().get24hTickerStatistics());
	}

	@Test
	void testGet24hTickerStatistics2() throws ApiException {
		testNotThrow(getClient().get24hTickerStatistics(new TickerStatisticsParams(symbol)));
	}

	@Test
	void testGet24hTickerStatistics3() throws ApiException {
		testNotThrow(getClient().get24hTickerStatistics(new TickersStatisticsParams(symbols)));
	}

	@Test
	void testGetAggTrades() throws ApiException {
		testNotThrow(getClient().getAggTrades(new AggTradeParams(symbol)));
	}

	@Test
	void testGetAggTrades2() throws ApiException {
		testNotThrow(getClient().getAggTrades(new AggTradeParams(symbol), new TimeFrame(limit)));
	}

	@Test
	void testGetAggTrades3() throws ApiException {
		testNotThrow(
				getClient().getAggTrades(new AggTradeParams(symbol), new TimeFrame(1640991600000L, 1640994900000L)));
	}

	@Test
	void testGetAggTrades4() throws ApiException {
		testNotThrow(getClient().getAggTrades(new AggTradeParams(symbol, 244397449L)));
	}

	@Test
	void testGetAveragePrice() throws ApiException {
		testNotThrow(getClient().getAveragePrice(new AveragePriceParams(symbol)));
	}

	@Test
	void testGetBookTicker() throws ApiException {
		testNotThrow(getClient().getBookTicker());
	}

	@Test
	void testGetBookTicker2() throws ApiException {
		testNotThrow(getClient().getBookTicker(new BookTickerParams(symbol)));
	}

	@Test
	void testGetBookTicker3() throws ApiException {
		testNotThrow(getClient().getBookTicker(new BookTickersParams(symbols)));
	}

	@Test
	void testGetExchangeInfo() throws ApiException {
		testNotThrow(getClient().getExchangeInfo());
	}

	@Test
	void testGetExchangeInfo2() throws ApiException {
		testNotThrow(getClient().getExchangeInfo(new ExchangeInfoParams(symbol)));
	}

	@Test
	void testGetHistoricalTrades() throws ApiException {
		testNotThrow(getClient().getHistoricalTrades(new HistoricalTradesParams(symbol)));
	}

	@Test
	void testGetHistoricalTrades2() throws ApiException {
		testNotThrow(getClient().getHistoricalTrades(new HistoricalTradesParams(symbol, limit)));
	}

	@Test
	void testGetHistoricalTrades3() throws ApiException {
		testNotThrow(getClient().getHistoricalTrades(new HistoricalTradesParams(symbol, 186647289L)));
	}

	@Test
	void testGetHistoricalTrades4() throws ApiException {
		testNotThrow(getClient().getHistoricalTrades(new HistoricalTradesParams(symbol, limit, 186647289L)));
	}

	@Test
	void testGetKlines() throws ApiException {
		List<CandlestickInterval> intervals = new LinkedList<>(List.of(CandlestickInterval.values()));
		intervals.remove(CandlestickInterval.MONTHLY_VISION);
		for (CandlestickInterval interval : intervals) {
			KlinesParams params = new KlinesParams(symbol, interval);
			testNotThrow(getClient().getKlines(params));
		}
	}

	@Test
	void testGetKlines2() throws ApiException {
		testNotThrow(getClient().getKlines(new KlinesParams(symbol, CandlestickInterval.HOURLY), new TimeFrame(limit)));
	}

	@Test
	void testGetOrderBook() throws ApiException {
		testNotThrow(getClient().getOrderBook(new OrderBookParams(symbol)));
	}

	@Test
	void testGetOrderBook2() throws ApiException {
		testNotThrow(getClient().getOrderBook(new OrderBookParams(symbol, OrderBookLimit.LIMIT_10)));
	}

	@Test
	void testGetServerTime() throws ApiException {
		testNotThrow(getClient().getServerTime());
	}

	@Test
	void testGetTicker() throws ApiException {
		testNotThrow(getClient().getTicker());
	}

	@Test
	void testGetTicker2() throws ApiException {
		testNotThrow(getClient().getTicker(new PriceTickerParams(symbol)));
	}

	@Test
	void testGetTicker3() throws ApiException {
		testNotThrow(getClient().getTicker(new PriceTickersParams(symbols)));
	}

	@Test
	void testGetTrades() throws ApiException {
		testNotThrow(getClient().getTrades(new TradesParams(symbol)));
	}

	@Test
	void testGetTrades2() throws ApiException {
		testNotThrow(getClient().getTrades(new TradesParams(symbol, limit)));
	}

	@Test
	void testPing() throws ApiException {
		testNotThrow(getClient().ping());
	}
}
