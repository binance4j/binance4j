package com.binance4j.strategy.strategies;

import com.binance4j.strategy.trading.BaseTradingStrategy;
import org.ta4j.core.BarSeries;
import org.ta4j.core.Rule;
import org.ta4j.core.indicators.RSIIndicator;
import org.ta4j.core.indicators.SMAIndicator;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;
import org.ta4j.core.rules.CrossedDownIndicatorRule;
import org.ta4j.core.rules.CrossedUpIndicatorRule;
import org.ta4j.core.rules.OverIndicatorRule;
import org.ta4j.core.rules.UnderIndicatorRule;

/**
 * Test Strategy
 */
public class TwoPeriodRSIStrategy extends BaseTradingStrategy {

	@Override
	public Rule getEntry(BarSeries series) {
		ClosePriceIndicator closePrice = new ClosePriceIndicator(series);
		SMAIndicator shortSma = new SMAIndicator(closePrice, 5);
		SMAIndicator longSma = new SMAIndicator(closePrice, 200);

		// We use a 2-period RSI indicator to identify buying
		// or selling opportunities within the bigger trend.
		RSIIndicator rsi = new RSIIndicator(closePrice, 2);

		// Entry rule
		// The long-term trend is up when a security is above its 200-period SMA.
		return new OverIndicatorRule(shortSma, longSma) // Trend
				.and(new CrossedDownIndicatorRule(rsi, 5)) // Signal 1
				.and(new OverIndicatorRule(shortSma, closePrice)); // Signal 2
	}

	@Override
	public Rule getExit(BarSeries series) {
		ClosePriceIndicator closePrice = new ClosePriceIndicator(series);
		SMAIndicator shortSma = new SMAIndicator(closePrice, 5);
		SMAIndicator longSma = new SMAIndicator(closePrice, 200);

		// We use a 2-period RSI indicator to identify buying
		// or selling opportunities within the bigger trend.
		RSIIndicator rsi = new RSIIndicator(closePrice, 2);

		// Exit rule
		// The long-term trend is down when a security is below its 200-period SMA.
		return new UnderIndicatorRule(shortSma, longSma) // Trend
				.and(new CrossedUpIndicatorRule(rsi, 95)) // Signal 1
				.and(new UnderIndicatorRule(shortSma, closePrice)); // Signal 2
	}
}
