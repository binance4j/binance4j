package com.binance4j.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	/**
	 * Concats the current strategy with the given
	 * 
	 * @param strategies The other strategies.
	 * @return The concatenation.
	 */
	default TradingStrategy[] concat(TradingStrategy... strategies) {
		List<TradingStrategy> list = new ArrayList<>(Arrays.asList(strategies));
		list.add(this);
		return list.toArray(new TradingStrategy[list.size()]);
	}
}