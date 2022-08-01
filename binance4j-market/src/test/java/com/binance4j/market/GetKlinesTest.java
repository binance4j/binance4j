package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.dto.Candle;
import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.market.param.KlinesParams;

class GetKlinesTest extends MarketTest {
	@Test
	void test1() throws ApiException {
		List<CandlestickInterval> intervals = new LinkedList<>(List.of(CandlestickInterval.values()));
		intervals.remove(CandlestickInterval.MONTHLY_VISION);
		for (CandlestickInterval interval : intervals) {
			KlinesParams params = new KlinesParams(symbol, interval);
			List<Candle> res = client.getKlines(params).execute();
			testNoNulls(res);
		}
	}

	@Test
	void test2() throws ApiException {
		KlinesParams params = new KlinesParams(symbol, CandlestickInterval.HOURLY);
		List<Candle> res = client.getKlines(params, new TimeFrame(limit)).execute();
		assertEquals(limit, res.size());
		testNoNulls(res);
	}
}
