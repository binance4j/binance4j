package com.binance4j.market.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.market.Candle;
import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.market.kline.KlinesRequest;
import com.binance4j.market.service.TestService;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GetKlinesTest extends ConcurrentTest {
	final MarketClient client = TestService.CLIENT;

	static void test(List<Candle> candles) {
		candles.forEach(candle -> assertTrue(TestService.hasNoNullProperty(candle)));
	}

	@Test
	@DisplayName("It sould return a candlestick for each interval")
	void testGetKlinesOnAllIntervals() throws ApiException {
		List<CandlestickInterval> intervals = new LinkedList<>(Arrays.asList(CandlestickInterval.values()));
		intervals.remove(CandlestickInterval.MONTHLY_VISION);

		for (CandlestickInterval interval : intervals) {
			KlinesRequest req = new KlinesRequest(TestService.SYMBOL, interval);
			List<Candle> res = client.getKlines(req).execute();
			test(res);
		}

	}

	@Test
	@DisplayName("It sould return a candlestick for the given symbol, interval with the asked size")
	void testGetKlinesWithLimit() throws ApiException {
		int limit = 25;
		KlinesRequest req = new KlinesRequest(TestService.SYMBOL, CandlestickInterval.HOURLY, limit);
		List<Candle> res = client.getKlines(req).execute();

		assertEquals(limit, res.size());
		test(res);
	}
}
