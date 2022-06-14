package com.binance4j.strategy.backtesting;

import lombok.Data;
import org.ta4j.core.BarSeries;
import org.ta4j.core.TradingRecord;

/**
 * A backtest result wrapper containing the strategy positions and its
 * statistics
 */
@Data
public class BackTestResult {
	/**
	 * The series the backtest run
	 */
	BarSeries series;
	/**
	 * The backtest positions statistics
	 */
	TradingStatistics statistics;
	/**
	 * The positions record
	 */
	TradingRecord tradingRecord;

	/**
	 * @param series        The series the backtest run
	 * @param tradingRecord The positions record
	 */
	public BackTestResult(BarSeries series, TradingRecord tradingRecord) {
		this.series = series;
		this.tradingRecord = tradingRecord;
		statistics = new TradingStatistics(tradingRecord, series);
	}
}
