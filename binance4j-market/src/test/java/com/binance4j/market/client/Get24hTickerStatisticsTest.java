package com.binance4j.market.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.market.service.TestService;
import com.binance4j.market.tickerstatistics.TickerStatistics;
import com.binance4j.market.tickerstatistics.TickerStatisticsRequest;
import com.binance4j.market.tickerstatistics.TickersStatisticsRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Get24hTickerStatisticsTest extends ConcurrentTest {
	final MarketClient client = TestService.CLIENT;

	/**
	 * Tests that no parameter in the statistics is null
	 *
	 * @param stats The 24h stats
	 */
	static void testStats(TickerStatistics stats) {
		assertNotNull(stats.getSymbol());
		assertNotNull(stats.getAskPrice());
		assertNotNull(stats.getAskQty());
		assertNotNull(stats.getBidPrice());
		assertNotNull(stats.getBidQty());
		assertNotNull(stats.getCloseTime());
		assertNotNull(stats.getCount());
		assertNotNull(stats.getFirstId());
		assertNotNull(stats.getHighPrice());
		assertNotNull(stats.getLastId());
		assertNotNull(stats.getLastPrice());
		assertNotNull(stats.getLastQty());
		assertNotNull(stats.getLowPrice());
		assertNotNull(stats.getOpenPrice());
		assertNotNull(stats.getOpenTime());
		assertNotNull(stats.getPrevClosePrice());
		assertNotNull(stats.getPriceChange());
		assertNotNull(stats.getPriceChangePercent());
		assertNotNull(stats.getQuoteVolume());
		assertNotNull(stats.getVolume());
		assertNotNull(stats.getWeightedAvgPrice());
	}

	@Test
	@DisplayName("Default Request should return result")
	void testGet24hTickerStatistics() throws ApiException {
		List<TickerStatistics> res = client.get24hTickerStatistics().execute();
		res.forEach(Get24hTickerStatisticsTest::testStats);
	}

	@Test
	@DisplayName("Request with symbol param should return result of asked symbol")
	void testGet24hTickerStatisticswithParams() throws ApiException {
		TickerStatisticsRequest req = new TickerStatisticsRequest(TestService.SYMBOL);
		TickerStatistics res = client.get24hTickerStatistics(req).execute();

		assertEquals(res.getSymbol(), req.getSymbol());
		testStats(res);
	}

	@Test
	@DisplayName("Request with specific symbols should return result of asked symbols")
	void testGet24hTickerStatisticswithSymbols() throws ApiException {
		TickersStatisticsRequest req = new TickersStatisticsRequest(TestService.SYMBOLS);
		List<TickerStatistics> res = client.get24hTickerStatistics(req).execute();

		res.forEach(stats -> {
			assertTrue(TestService.SYMBOLS.contains((stats.getSymbol())));
			testStats(stats);
		});
	}
}
