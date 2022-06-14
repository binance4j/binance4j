package com.binance4j.strategy.trading;

import java.time.ZoneId;
import java.util.Collection;
import java.util.List;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.market.CandlestickBar;
import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.strategy.backtesting.BackTestResult;
import com.binance4j.websocket.client.WebsocketCandlestickClient;

import org.ta4j.core.Bar;
import org.ta4j.core.BarSeries;
import org.ta4j.core.Indicator;
import org.ta4j.core.Rule;

/**
 * A trading strategy with an entry and an exit {@link Rule Rules} based on
 * technical {@link Indicator indicators}, able to analyse, backtest or live
 * test a {@link BarSeries} / {@link CandlestickBar}
 */
public interface TradingStrategy {

	/** Analysing */

	// BarSeries

	/**
	 * Tells if the strategy sends a BUY signal on the selected bar of the given
	 * {@link BarSeries}
	 * 
	 * @param series The {@link BarSeries} to analyze
	 * @param index  The {@link Bar} to analyze
	 * @return If the strategy sends a BUY signal
	 */
	boolean shouldEnter(BarSeries series, int index);

	/**
	 * Tells if the strategy sends a BUY signal on the last bar of the given
	 * {@link BarSeries}
	 * 
	 * @param series The {@link BarSeries} to analyze
	 * @return If the strategy sends a BUY signal
	 */
	boolean shouldEnter(BarSeries series);

	/**
	 * Tells if the strategy sends a SELL signal on the selected bar of the given
	 * {@link BarSeries}
	 * 
	 * @param series The {@link BarSeries} to analyze
	 * @param index  The {@link Bar} to analyze
	 * @return If the strategy sends a BUY signal
	 */
	boolean shouldExit(BarSeries series, int index);

	/**
	 * Tells if the strategy sends a SELL signal on the last bar of the given
	 * {@link BarSeries}
	 * 
	 * @param series The {@link BarSeries} to analyze
	 * @return If the strategy sends a BUY signal
	 */
	boolean shouldExit(BarSeries series);

	// Candlestick bars

	/**
	 * Tells if the strategy sends a BUY signal on the selected bar of the given
	 * {@link CandlestickInterval}
	 * 
	 * @param bars     The {@link CandlestickBar CandlestickBars} to analyze
	 * @param interval The interval between every bar
	 * @param index    The {@link Bar} to analyze
	 * @return If the strategy sends a BUY signal
	 */
	boolean shouldEnter(List<CandlestickBar> bars, CandlestickInterval interval, int index);

	/**
	 * Tells if the strategy sends a BUY signal on the selected bar of the given
	 * {@link CandlestickInterval}
	 * 
	 * @param bars     The {@link CandlestickBar CandlestickBars} to analyze
	 * @param interval The interval between every bar
	 * @return If the strategy sends a BUY signal
	 */
	boolean shouldEnter(List<CandlestickBar> bars, CandlestickInterval interval);

	/**
	 * Tells if the strategy sends a SELL signal on the selected bar of the given
	 * {@link CandlestickInterval}
	 * 
	 * @param bars     The {@link CandlestickBar CandlestickBars} to analyze
	 * @param interval The interval between every bar
	 * @param index    The {@link Bar} to analyze
	 * @return If the strategy sends a SELL signal
	 */
	boolean shouldExit(List<CandlestickBar> bars, CandlestickInterval interval, int index);

	/**
	 * Tells if the strategy sends a SELL signal on the selected bar of the given
	 * {@link CandlestickInterval}
	 * 
	 * @param bars     The {@link CandlestickBar CandlestickBars} to analyze
	 * @param interval The interval between every bar
	 * @return If the strategy sends a SELL signal
	 */
	boolean shouldExit(List<CandlestickBar> bars, CandlestickInterval interval);

	/** Live trading */

	/**
	 * Listens to the Klines websocket endpoint and runs the strategy over the
	 * received {@link BarSeries}
	 * 
	 * @param symbols  The symbols to listen to
	 * @param interval The candlestick interval
	 * @param zoneId   The {@link Bar} zone id
	 * @param callback The methods to call according to the server response
	 * @return The websocket client connected to the server
	 */
	WebsocketCandlestickClient watch(String symbols, CandlestickInterval interval,
			ZoneId zoneId,
			ApiStrategyCallback callback);

	/**
	 * Listens to the Klines websocket endpoint and runs the strategy over the
	 * received {@link BarSeries} with {@link ZoneId#systemDefault()}
	 * 
	 * @param symbols  The symbols to listen to
	 * @param interval The candlestick interval
	 * @param callback The methods to call according to the server response
	 * @return The websocket client connected to the server
	 */
	WebsocketCandlestickClient watch(String symbols, CandlestickInterval interval,
			ApiStrategyCallback callback);

	/**
	 * Listens to the Klines websocket endpoint and runs the strategy over the
	 * received {@link BarSeries}
	 * 
	 * @param symbols  The symbols to listen to
	 * @param interval The candlestick interval
	 * @param zoneId   The {@link Bar} zone id
	 * @param callback The methods to call according to the server response
	 * @return The websocket client connected to the server
	 */
	WebsocketCandlestickClient watch(Collection<String> symbols, CandlestickInterval interval,
			ZoneId zoneId,
			ApiStrategyCallback callback);

	/**
	 * Listens to the Klines websocket endpoint and runs the strategy over the
	 * received {@link BarSeries} with {@link ZoneId#systemDefault()}
	 * 
	 * @param symbols  The symbols to listen to
	 * @param interval The candlestick interval
	 * @param callback The methods to call according to the server response
	 * @return The websocket client connected to the server
	 */
	WebsocketCandlestickClient watch(Collection<String> symbols, CandlestickInterval interval,
			ApiStrategyCallback callback);

	/**
	 * Closes the websocket transaction
	 */
	void unwatch();

	/* Backtesting */

	/**
	 * Runs the strategy over a {@link BarSeries}
	 * 
	 * @param series The candlestick bars
	 * @return The {@link BackTestResult} of the trading session
	 */
	BackTestResult backTest(BarSeries series);

	/**
	 * Runs the strategy over a {@link CandlestickBar} list
	 * 
	 * @param bars     The candlestick bars
	 * @param interval The interval between two bars
	 * @return The {@link BackTestResult} of the trading session
	 */
	BackTestResult backTest(List<CandlestickBar> bars, CandlestickInterval interval);

	/**
	 * Runs a strategy over the data.binance.vision public spot klines data
	 * 
	 * @param symbol   The trading pair
	 * @param interval The candlestick interval
	 * @param year     The year of the data
	 * @param month    The month of the data
	 * @return The backtest result
	 * @throws ApiException
	 */
	BackTestResult backTest(String symbol, CandlestickInterval interval, String year,
			String month) throws ApiException;

	/**
	 * Runs a strategy over the data.binance.vision spot klines data
	 * 
	 * @param symbol   The trading pair
	 * @param interval The candlestick interval
	 * @param year     The year of the data
	 * @param month    The month of the data
	 * @param day      The day of the data
	 * @return The backtest result
	 * @throws ApiException
	 */
	BackTestResult backTest(String symbol, CandlestickInterval interval, String year,
			String month, String day) throws ApiException;

	/** Mandatory methods */

	/**
	 * The BUY signal {@link Rule}
	 * 
	 * @param series The {@link BarSeries}
	 * @return the entry rule
	 */
	Rule getEntry(BarSeries series);

	/**
	 * The SELL signal {@link Rule}
	 * 
	 * @param series The {@link BarSeries}
	 * @return the exit rule
	 */
	Rule getExit(BarSeries series);
}