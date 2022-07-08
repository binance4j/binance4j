package com.binance4j.strategy;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
import com.binance4j.strategy.dto.TradingStatistics;
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
		BackTestResult result = BackbackTest(strategy, series);
		assertStats(result.getStatistics());
	}

	@Test
	@DisplayName("The backtest should generate non null statistics")
	void testBacktestWithVision() throws ApiException {
		TwoPeriodRSIStrategy strategy = new TwoPeriodRSIStrategy();
		BackTestResult result = BackbackTest(strategy, "BTCBUSD", CandlestickInterval.FIVE_MINUTES, "2022",
				"01");
		assertStats(result.getStatistics());
	}

	void assertStats(TradingStatistics stats) {
		assertNotNull(stats.getAverageLoss());
		assertNotNull(stats.getAverageProfit());
		assertNotNull(stats.getAverageReturnPerBar());
		assertNotNull(stats.getBuyAndHoldReturn());
		assertNotNull(stats.getExpectancy());
		assertNotNull(stats.getExpectedShortfall(0.95));
		assertNotNull(stats.getGrossLoss());
		assertNotNull(stats.getGrossProfit());
		assertNotNull(stats.getGrossReturn());
		assertNotNull(stats.getLinearTransactionCost(1, 0.95));
		assertNotNull(stats.getLosingPositionsRatio());
		assertNotNull(stats.getMaximumDrawdown());
		assertNotNull(stats.getNetLoss());
		assertNotNull(stats.getNetProfit());
		assertNotNull(stats.getNumberOfBars());
		assertNotNull(stats.getNumberOfBreakEvenPositions());
		assertNotNull(stats.getNumberOfConsecutiveWinningPositions());
		assertNotNull(stats.getNumberOfLosingPositions());
		assertNotNull(stats.getNumberOfPositions());
		assertNotNull(stats.getNumberOfWinningPositions());
		assertNotNull(stats.getProfitLoss());
		assertNotNull(stats.getProfitLossPercentage());
		assertNotNull(stats.getReturnOverMaxDrawdown());
		assertNotNull(stats.getValueAtRisk(0.95));
		assertNotNull(stats.getWinningPositionsRatio());
	}
}