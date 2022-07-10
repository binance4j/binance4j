package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.market.tickerstatistics.TickerStatistics;
import com.binance4j.market.tickerstatistics.TickerStatisticsRequest;
import com.binance4j.market.tickerstatistics.TickersStatisticsRequest;

class Get24hTickerStatisticsTest extends MarketTest {
	@Test
	@DisplayName("Response must not contain null properties")
	void test1() throws ApiException {
		test(getClient().get24hTickerStatistics());
	}

	@Test
	@DisplayName("Response must not contain null properties and symbol must match")
	void test2() throws ApiException {
		TickerStatisticsRequest req = new TickerStatisticsRequest(symbol);
		TickerStatistics res = getClient().get24hTickerStatistics(req).execute();

		assertEquals(res.getSymbol(), req.getSymbol());
		test(res);
	}

	@Test
	@DisplayName("Response must not contain null properties and symbols must match")
	void test3() throws ApiException {
		TickersStatisticsRequest req = new TickersStatisticsRequest(symbols);
		List<TickerStatistics> res = getClient().get24hTickerStatistics(req).execute();

		test(res);
		res.forEach(stats -> assertTrue(symbols.contains((stats.getSymbol()))));
	}
}