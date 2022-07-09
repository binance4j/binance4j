package com.binance4j.strategy;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
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

class BackTestingTest extends ConcurrentTest {

	@Test
	@DisplayName("The backtest should generate non null statistics")
	void testBacktestWithInputBars() throws ApiException {
		// Let's get some public data
		List<Candle> bars = new VisionSpotClient()
				.getKlines("BTCBUSD", CandlestickInterval.FIVE_MINUTES, "2022", "01").getData();
		BarSeries series = BarSeriesService.convert(bars, Duration.ofMinutes(5));
		TwoPeriodRSIStrategy strategy = new TwoPeriodRSIStrategy();
		BackTestResult result = BackTestService.backTest(strategy, series);
		test(result.getStatistics());
	}

	@Test
	@DisplayName("The backtest should generate non null statistics")
	void testBacktestWithVision() throws ApiException {
		TwoPeriodRSIStrategy strategy = new TwoPeriodRSIStrategy();
		BackTestResult result = BackTestService.backTest(strategy, "BTCBUSD", CandlestickInterval.FIVE_MINUTES, "2022",
				"01");
		test(result.getStatistics());
	}
}