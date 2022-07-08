package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.market.Candle;
import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.market.kline.KlinesRequest;

class GetKlinesTest extends MarketTest {

	@Test
	@DisplayName("It sould return a candlestick for each interval")
	void test1() throws ApiException {
		List<CandlestickInterval> intervals = new LinkedList<>(Arrays.asList(CandlestickInterval.values()));
		intervals.remove(CandlestickInterval.MONTHLY_VISION);

		for (CandlestickInterval interval : intervals) {
			KlinesRequest req = new KlinesRequest(symbol, interval);
			List<Candle> res = client.getKlines(req).execute();
			test(res);
		}
	}

	@Test
	@DisplayName("It sould return a candlestick for the given symbol and interval with the asked size")
	void test2() throws ApiException {
		KlinesRequest req = new KlinesRequest(symbol, CandlestickInterval.HOURLY, limit);
		List<Candle> res = client.getKlines(req).execute();

		assertEquals(limit, res.size());
		test(res);
	}
}
