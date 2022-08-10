package com.binance4j.strategy.service;

import java.util.List;

import org.ta4j.core.BarSeries;
import org.ta4j.core.BarSeriesManager;

import com.binance4j.core.dto.Candle;
import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.exception.ApiException;
import com.binance4j.strategy.TradingStrategy;
import com.binance4j.strategy.dto.BackTestResult;
import com.binance4j.vision.client.VisionSpotClient;
import com.binance4j.websocket.service.DurationService;

/** Service to backtest a {@link TradingStrategy} */
public class BackTestService {
	/** Constructor */
	private BackTestService() {
	}

	/**
	 * Runs the strategy over a {@link BarSeries}.
	 * 
	 * @param strategy {@link TradingStrategy} to backtest.
	 * @param series   Candles.
	 * @return {@link BackTestResult} of the trading session.
	 */
	public static BackTestResult backTest(TradingStrategy strategy, BarSeries series) {
		return new BackTestResult(series, new BarSeriesManager(series).run(StrategyBuilder.build(strategy, series)));
	}

	/**
	 * Runs the strategy over a {@link Candle} list.
	 * 
	 * @param strategy {@link TradingStrategy} to backtest.
	 * @param bars     Candles.
	 * @param interval Interval between two bars.
	 * @return {@link BackTestResult} of the trading session.
	 */
	public static BackTestResult backTest(TradingStrategy strategy, List<Candle> bars, CandlestickInterval interval) {
		return backTest(strategy, BarSeriesService.convert(bars, DurationService.convert(interval)));
	}

	/**
	 * Runs a strategy over the data.binance.vision public spot klines data.
	 * 
	 * @param strategy {@link TradingStrategy} to backtest.
	 * @param symbol   Trading pair.
	 * @param interval Candlestick interval.
	 * @param year     Year of the data.
	 * @param month    Month of the data.
	 * @return The backtest result.
	 * @throws ApiException Thrown if data fetching failed
	 */
	public static BackTestResult backTest(TradingStrategy strategy, String symbol, CandlestickInterval interval,
			String year, String month)
			throws ApiException {
		List<Candle> bars = new VisionSpotClient().getKlines(symbol, interval, year, month).getData();
		return backTest(strategy, bars, interval);
	}

	/**
	 * Runs a strategy over the data.binance.vision spot klines data.
	 * 
	 * @param strategy {@link TradingStrategy} to backtest.
	 * @param symbol   Trading pair.
	 * @param interval Candlestick interval.
	 * @param year     Year of the data.
	 * @param month    Month of the data.
	 * @param day      Day of the data.
	 * @return The backtest result.
	 * @throws ApiException Thrown if data fetching failed
	 */
	public static BackTestResult backTest(TradingStrategy strategy, String symbol, CandlestickInterval interval,
			String year, String month, String day)
			throws ApiException {
		List<Candle> bars = new VisionSpotClient().getKlines(symbol, interval, year, month, day).getData();
		return backTest(strategy, bars, interval);
	}
}