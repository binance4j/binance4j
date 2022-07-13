package com.binance4j.strategy;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.ta4j.core.Position;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.strategy.dto.BackTestResult;
import com.binance4j.strategy.service.BackTestService;
import com.binance4j.strategy.service.PositionService;
import com.binance4j.strategy.strategies.TwoPeriodRSIStrategy;

class AnalysingTest extends ConcurrentTest<Void> {

	@Test
	void testBacktestWithInputBars() throws ApiException {
		TwoPeriodRSIStrategy strategy = new TwoPeriodRSIStrategy();
		BackTestResult result = BackTestService.backTest(strategy, "BTCBUSD", CandlestickInterval.FIVE_MINUTES, "2022",
				"01");
		List<Position> positions = result.getTradingRecord().getPositions();

		positions.forEach(p -> {
			assertTrue(PositionService.shouldEnter(strategy, result.getSeries(), p.getEntry().getIndex()));
			assertTrue(PositionService.shouldExit(strategy, result.getSeries(), p.getExit().getIndex()));
		});
	}

}
