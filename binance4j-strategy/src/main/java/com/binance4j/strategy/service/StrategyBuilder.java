package com.binance4j.strategy.service;

import org.ta4j.core.BarSeries;
import org.ta4j.core.BaseStrategy;
import org.ta4j.core.Strategy;

import com.binance4j.strategy.TradingStrategy;

/** Service to build a ta4j strategy over a {@link TradingStrategy}. */
public class StrategyBuilder {
	private StrategyBuilder() {
	}

	/**
	 * Builds a trading strategy from a {@link TradingStrategy} and a
	 * {@link BarSeries}
	 *
	 * @param strategy {@link TradingStrategy}.
	 * @param series   {@link BarSeries}.
	 * @return The generated t4j {@link Strategy}.
	 */
	public static Strategy build(TradingStrategy strategy, BarSeries series) {
		return new BaseStrategy(strategy.entry(series), strategy.exit(series));
	}
}
