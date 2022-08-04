package com.binance4j.strategy;

import org.ta4j.core.BarSeries;
import org.ta4j.core.Indicator;
import org.ta4j.core.Rule;

import com.binance4j.core.dto.Candle;

/**
 * A trading strategy with an entry and an exit {@link Rule Rules} based on technical {@link Indicator indicators}, able
 * to analyse, backtest or live test a {@link BarSeries} / {@link Candle}
 */
public interface TradingStrategy {
	/**
	 * The BUY signal {@link Rule}
	 *
	 * @param series The {@link BarSeries}.
	 * @return the entry rule.
	 */
	Rule entry(BarSeries series);

	/**
	 * The SELL signal {@link Rule}
	 *
	 * @param series The {@link BarSeries}.
	 * @return the exit rule.
	 */
	Rule exit(BarSeries series);
}