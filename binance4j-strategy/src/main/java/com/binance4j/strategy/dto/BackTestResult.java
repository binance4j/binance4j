package com.binance4j.strategy.dto;

import org.ta4j.core.BarSeries;
import org.ta4j.core.TradingRecord;

/**
 * A backtest result wrapper containing the strategy positions and its statistics.
 * 
 * @param series        The series the backtest run.
 * @param statistics    The backtest positions statistics.
 * @param tradingRecord The positions record.
 */
public record BackTestResult(BarSeries series, TradingStatistics statistics, TradingRecord tradingRecord) {
	/**
	 * @param series        The series the backtest run.
	 * @param tradingRecord The positions record.
	 */
	public BackTestResult(BarSeries series, TradingRecord tradingRecord) {
		this(series, new TradingStatistics(tradingRecord, series), tradingRecord);
	}
}
