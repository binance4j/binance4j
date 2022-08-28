package com.binance4j.strategy.dto;

import org.ta4j.core.BarSeries;
import org.ta4j.core.TradingRecord;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A backtest result wrapper containing the strategy positions and its
 * statistics.
 * 
 * @property series        Series the backtest run.
 * @property statistics    Backtest positions statistics.
 * @property tradingRecord Positions record.
 */
@ApiModel("A backtest result wrapper containing the strategy positions and its statistics.")
data class BackTestResult(@ApiModelProperty("Series the backtest run.")
var series:BarSeries?=null,
@ApiModelProperty("Backtest positions statistics.")
var statistics:TradingStatistics?=null,
@ApiModelProperty("Positions record.")
var tradingRecord:TradingRecord?=null)
{

	/**
	 * @property series        Series the backtest run.
	 * @property tradingRecord Positions record.
	 */
	public BackTestResult(BarSeries series, TradingRecord tradingRecord) {
		this(series, new TradingStatistics(tradingRecord, series), tradingRecord);
	}
}
