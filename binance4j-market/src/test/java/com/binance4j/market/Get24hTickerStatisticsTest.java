package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.market.dto.TickerStatistics;
import com.binance4j.market.param.TickerStatisticsParams;
import com.binance4j.market.param.TickersStatisticsParams;

class Get24hTickerStatisticsTest extends MarketTest {
	@Test
	void test1() throws ApiException {
		test(client.get24hTickerStatistics());
	}

	@Test
	void test2() throws ApiException {
		TickerStatisticsParams params = new TickerStatisticsParams(symbol);
		TickerStatistics res = client.get24hTickerStatistics(params).execute();

		assertEquals(res.symbol(), params.getSymbol());
		test(res);
	}

	@Test
	void test3() throws ApiException {
		TickersStatisticsParams params = new TickersStatisticsParams(symbols);
		List<TickerStatistics> res = client.get24hTickerStatistics(params).execute();

		test(res);
		res.forEach(stats -> assertTrue(symbols.contains((stats.symbol()))));
	}
}