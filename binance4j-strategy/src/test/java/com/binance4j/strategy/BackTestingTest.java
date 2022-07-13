package com.binance4j.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.ta4j.core.BarSeries;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.market.Candle;
import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.strategy.dto.BackTestResult;
import com.binance4j.strategy.service.BackTestService;
import com.binance4j.strategy.service.BarSeriesService;
import com.binance4j.strategy.strategies.TwoPeriodRSIStrategy;
import com.binance4j.vision.spot.VisionSpotClient;

class BackTestingTest extends ConcurrentTest<Void> {

	@Override
	public void test(Object bean) {
		Set<String> nulls = getNullProperties(bean, true);
		List<String> expected = Arrays.asList("amount", "entry", "exit", "name");
		System.out.println(nulls);
		assertEquals(expected.size(), nulls.size());
		assertTrue(nulls.containsAll(expected));
	}

	@Test
	void testBacktestWithInputBars() throws ApiException {
		// Let's get some public data
		List<Candle> bars = new VisionSpotClient()
				.getKlines("BTCBUSD", CandlestickInterval.ONE_MINUTE, "2022", "01", "01").getData();
		BarSeries series = BarSeriesService.convert(bars, Duration.ofMinutes(1));
		TwoPeriodRSIStrategy strategy = new TwoPeriodRSIStrategy();
		BackTestResult result = BackTestService.backTest(strategy, series);
		test(result);
	}

	@Test
	void testBacktestWithVision() throws ApiException {
		TwoPeriodRSIStrategy strategy = new TwoPeriodRSIStrategy();
		BackTestResult result = BackTestService.backTest(strategy, "BTCBUSD", CandlestickInterval.ONE_MINUTE, "2022",
				"01", "01");
		test(result);
	}
}