package com.binance4j.strategy.strategies;

import org.jetbrains.annotations.NotNull;
import org.ta4j.core.BarSeries;
import org.ta4j.core.Rule;
import org.ta4j.core.indicators.helpers.ConstantIndicator;
import org.ta4j.core.rules.BooleanIndicatorRule;
import com.binance4j.strategy.TradingStrategy;

/** A strategy that always exits */
public class AlwaysExitStrategy implements TradingStrategy {
	@NotNull
	@Override
	public Rule entry(BarSeries series) {
		return new BooleanIndicatorRule(new ConstantIndicator<>(series, false));
	}

	@NotNull
	@Override
	public Rule exit(BarSeries series) {
		return new BooleanIndicatorRule(new ConstantIndicator<>(series, true));
	}
}
