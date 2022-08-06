package com.binance4j.strategy.dto;

import org.ta4j.core.BarSeries;
import org.ta4j.core.TradingRecord;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A backtest result wrapper containing the strategy positions and its statistics.
 * 
 * @param series        Series the backtest run.
 * @param statistics    Backtest positions statistics.
 * @param tradingRecord Positions record.
 */
@ApiModel("A backtest result wrapper containing the strategy positions and its statistics.")
public record BackTestResult(@ApiModelProperty("Series the backtest run.") BarSeries series,
		@ApiModelProperty("Backtest positions statistics.") TradingStatistics statistics, @ApiModelProperty("Positions record.") TradingRecord tradingRecord) {
	/**
	 * @param series        Series the backtest run.
	 * @param tradingRecord Positions record.
	 */
	public BackTestResult(BarSeries series, TradingRecord tradingRecord) {
		this(series, new TradingStatistics(tradingRecord, series), tradingRecord);
	}
}
