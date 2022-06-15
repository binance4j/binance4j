package com.binance4j.strategy.strategies;

import org.ta4j.core.BarSeries;
import org.ta4j.core.Rule;
import org.ta4j.core.indicators.helpers.ConstantIndicator;
import org.ta4j.core.rules.BooleanIndicatorRule;

import com.binance4j.strategy.TradingStrategy;

/**
 * A strategy that always enters
 */
public class AlwaysEnterStrategy implements TradingStrategy {
	@Override
	public Rule entry(BarSeries series) {
		return new BooleanIndicatorRule(new ConstantIndicator<>(series, true));
	}

	@Override
	public Rule exit(BarSeries series) {
		return new BooleanIndicatorRule(new ConstantIndicator<>(series, false));
	}
}
