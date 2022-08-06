package com.binance4j.strategy.dto;

import org.ta4j.core.BarSeries;
import org.ta4j.core.TradingRecord;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A backtest result wrapper containing the strategy positions and its statistics.
 * 
 * @param series        The series the backtest run.
 * @param statistics    The backtest positions statistics.
 * @param tradingRecord The positions record.
 */
@ApiModel("")
public record BackTestResult(@ApiModelProperty("") BarSeries series, @ApiModelProperty("") TradingStatistics statistics,
		@ApiModelProperty("") TradingRecord tradingRecord) {
	/**
	 * @param series        The series the backtest run.
	 * @param tradingRecord The positions record.
	 */
	public BackTestResult(BarSeries series, TradingRecord tradingRecord) {
		this(series, new TradingStatistics(tradingRecord, series), tradingRecord);
	}
}
