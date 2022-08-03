package com.binance4j.strategy;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.ta4j.core.BarSeries;

import com.binance4j.core.dto.Candle;
import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;
import com.binance4j.strategy.dto.BackTestResult;
import com.binance4j.strategy.service.BackTestService;
import com.binance4j.strategy.service.BarSeriesService;
import com.binance4j.strategy.strategies.TwoPeriodRSIStrategy;
import com.binance4j.vision.client.VisionSpotClient;

class BackTestingTest extends CustomTest {
	@Test
	void testBacktestWithInputBars() throws ApiException {
		// Let's get some public data
		List<Candle> bars = new VisionSpotClient().getKlines("BTCBUSD", CandlestickInterval.ONE_MINUTE, "2022", "01", "01").getData();
		BarSeries series = BarSeriesService.convert(bars, Duration.ofMinutes(1));
		TwoPeriodRSIStrategy strategy = new TwoPeriodRSIStrategy();
		BackTestResult result = BackTestService.backTest(strategy, series);
		testHasNulls(result, List.of("amount", "entry", "exit", "name"), true);
	}

	@Test
	void testBacktestWithVision() throws ApiException {
		TwoPeriodRSIStrategy strategy = new TwoPeriodRSIStrategy();
		BackTestResult result = BackTestService.backTest(strategy, "BTCBUSD", CandlestickInterval.ONE_MINUTE, "2022", "01", "01");
		testHasNulls(result, List.of("amount", "entry", "exit", "name"), true);
	}
}