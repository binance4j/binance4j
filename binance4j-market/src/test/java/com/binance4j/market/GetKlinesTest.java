package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.market.Candle;
import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.market.kline.KlinesParams;

class GetKlinesTest extends MarketTest {

	@Test

	void test1() throws ApiException {
		List<CandlestickInterval> intervals = new LinkedList<>(Arrays.asList(CandlestickInterval.values()));
		intervals.remove(CandlestickInterval.MONTHLY_VISION);

		for (CandlestickInterval interval : intervals) {
			KlinesParams params = new KlinesParams(symbol, interval);
			List<Candle> res = client.getKlines(params).execute();
			test(res);
		}
	}

	@Test

	void test2() throws ApiException {
		KlinesParams params = new KlinesParams(symbol, CandlestickInterval.HOURLY, limit);
		List<Candle> res = client.getKlines(params).execute();

		assertEquals(limit, res.size());
		test(res);
	}
}
