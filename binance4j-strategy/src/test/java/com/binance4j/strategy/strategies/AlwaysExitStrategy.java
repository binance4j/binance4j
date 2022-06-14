package com.binance4j.strategy.strategies;

import com.binance4j.strategy.trading.BaseTradingStrategy;

import org.ta4j.core.BarSeries;
import org.ta4j.core.Rule;
import org.ta4j.core.indicators.helpers.ConstantIndicator;
import org.ta4j.core.rules.BooleanIndicatorRule;

/**
 * A strategy that always exits
 */
public class AlwaysExitStrategy extends BaseTradingStrategy {
    @Override
    public Rule getEntry(BarSeries series) {
        return new BooleanIndicatorRule(new ConstantIndicator<>(series, false));
    }

    @Override
    public Rule getExit(BarSeries series) {
        return new BooleanIndicatorRule(new ConstantIndicator<>(series, true));
    }
}
