package com.binance4j.strategy.strategies;

import org.ta4j.core.BarSeries;
import org.ta4j.core.Rule;
import org.ta4j.core.indicators.helpers.ConstantIndicator;
import org.ta4j.core.rules.BooleanIndicatorRule;

import com.binance4j.strategy.trading.TradingStrategy;

/**
 * A strategy that always exits
 */
public class AlwaysExitStrategy implements TradingStrategy {
	@Override
	public Rule entry(BarSeries series) {
		return new BooleanIndicatorRule(new ConstantIndicator<>(series, false));
	}

	@Override
	public Rule exit(BarSeries series) {
		return new BooleanIndicatorRule(new ConstantIndicator<>(series, true));
	}
}
