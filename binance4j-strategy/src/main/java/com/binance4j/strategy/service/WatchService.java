package com.binance4j.strategy.service;

import java.time.Duration;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.ta4j.core.Bar;
import org.ta4j.core.BarSeries;
import org.ta4j.core.BaseBarSeries;
import org.ta4j.core.Strategy;

import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.exception.ApiException;
import com.binance4j.strategy.StrategyCallback;
import com.binance4j.strategy.TradingStrategy;
import com.binance4j.strategy.dto.SymbolBar;
import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.callback.WebsocketCloseObject;
import com.binance4j.websocket.client.WebsocketCandlestickClient;
import com.binance4j.websocket.configuration.WebsocketClientConfiguration;
import com.binance4j.websocket.dto.Candle;
import com.binance4j.websocket.service.DurationService;

import okhttp3.Response;

/** Service to live trade a {@link TradingStrategy}. */
public class WatchService {
	/** The websocket client configuration */
	WebsocketClientConfiguration configuration;
	/** The BarSeries max size. Default 500 */
	int maximumBarCount = 500;
	/** The websocket client */
	protected WebsocketCandlestickClient wsClient;
	/** The series used in watch mode */
	protected Map<String, BarSeries> barSeries;
	/** The trading strategy */
	protected TradingStrategy tradingStrategy;
	/** The live trading callback */
	protected StrategyCallback callback;

	/**
	 * @param strategy Strategy used to live trade.
	 */
	public WatchService(TradingStrategy strategy, StrategyCallback callback) {
		this.tradingStrategy = strategy;
		this.callback = callback;
		configuration = new WebsocketClientConfiguration();
	}

	/**
	 * Updates all the series max size, preventing memory overload
	 *
	 * @param maximumBarCount Series size.
	 */
	public void setMaximumBarCount(int maximumBarCount) {
		this.maximumBarCount = maximumBarCount;
		barSeries.values().forEach(series -> series.setMaximumBarCount(maximumBarCount));
	}

	/**
	 * Listens to the Klines websocket endpoint and runs the strategy over the received {@link BarSeries}
	 *
	 * @param symbols  Symbols to listen to.
	 * @param interval Candlestick interval.
	 * @param zoneId   {@link Bar} zone id.
	 * @return The websocket client connected to the server.
	 */
	public WebsocketCandlestickClient watch(String symbols, CandlestickInterval interval, ZoneId zoneId) {
		barSeries = new HashMap<>();
		// let's initialize a BarSeries for each symbol with the symbol as name of the series and a limit size
		Arrays.stream(symbols.split(",")).map(String::trim).forEach(symbol -> {
			BarSeries bar = new BaseBarSeries(symbol);
			bar.setMaximumBarCount(maximumBarCount);
			barSeries.put(symbol, bar);
		});

		Duration duration = DurationService.convert(interval);
		wsClient = new WebsocketCandlestickClient(symbols, interval, new WebsocketCallback<Candle>() {
			public void onMessage(Candle response) {
				// let's convert the bar and give it the symbol name
				Bar bar = BarService.convert(response, duration, zoneId);
				callback.onMessage(new SymbolBar(bar, response.isBarFinal(), response.symbol()));
				// we determinate what method to call according to the strategy
				if (response.isBarFinal()) {
					BarSeries series = barSeries.get(response.symbol());
					series.addBar(bar);
					int lastIndex = series.getBarCount() - 1;
					// we add the bar to the series
					Strategy strategy = StrategyBuilder.build(tradingStrategy, series);
					if (strategy.shouldEnter(lastIndex)) {
						callback.onEnter(series);
					} else if (strategy.shouldExit(lastIndex)) {
						callback.onExit(series);
					}
				}
			}

			@Override
			public void onOpen(Response response) {
				callback.onOpen(response);
			}

			@Override
			public void onClosed(WebsocketCloseObject websocketCloseObject) {
				callback.onClosed(websocketCloseObject);
			}

			@Override
			public void onClosing(WebsocketCloseObject websocketCloseObject) {
				callback.onClosing(websocketCloseObject);
			}

			@Override
			public void onFailure(ApiException exception) {
				callback.onFailure(exception);
			}
		});
		wsClient.setConfiguration(configuration);
		wsClient.open();
		return wsClient;
	}

	/**
	 * Listens to the Klines websocket endpoint and runs the strategy over the received {@link BarSeries}
	 *
	 * @param symbols  Symbols to listen to.
	 * @param interval Candlestick interval.
	 * @param zoneId   {@link Bar} zone id.
	 * @return The websocket client connected to the server.
	 */
	public WebsocketCandlestickClient watch(Collection<String> symbols, CandlestickInterval interval, ZoneId zoneId) {
		return watch(String.join(",", symbols), interval, zoneId);
	}

	/**
	 * Listens to the Klines websocket endpoint and runs the strategy over the received {@link BarSeries} with
	 * {@link ZoneId#systemDefault()}
	 *
	 * @param symbols  Symbols to listen to.
	 * @param interval Candlestick interval.
	 * @return The websocket client connected to the server.
	 */
	public WebsocketCandlestickClient watch(String symbols, CandlestickInterval interval) {
		return watch(symbols, interval, ZoneId.systemDefault());
	}

	/**
	 * Listens to the Klines websocket endpoint and runs the strategy over the received {@link BarSeries} with
	 * {@link ZoneId#systemDefault()}
	 *
	 * @param symbols  Symbols to listen to.
	 * @param interval Candlestick interval.
	 * @return The websocket client connected to the server.
	 */
	public WebsocketCandlestickClient watch(Collection<String> symbols, CandlestickInterval interval) {
		return watch(String.join(",", symbols), interval);
	}

	/** Closes the websocket transaction */
	public void unwatch() {
		if (wsClient != null)
			wsClient.close();
	}

	/**
	 * @return the configuration
	 */
	public WebsocketClientConfiguration getConfiguration() {
		return configuration;
	}

	/**
	 * @param configuration Configuration to set
	 */
	public void setConfiguration(WebsocketClientConfiguration configuration) {
		this.configuration = configuration;
	}

	/**
	 * @return the maximumBarCount
	 */
	public int getMaximumBarCount() {
		return maximumBarCount;
	}

	/**
	 * @return the tradingStrategy
	 */
	public TradingStrategy getTradingStrategy() {
		return tradingStrategy;
	}

	/**
	 * @param tradingStrategy TradingStrategy to set
	 */
	public void setTradingStrategy(TradingStrategy tradingStrategy) {
		this.tradingStrategy = tradingStrategy;
	}

	/**
	 * @return the callback
	 */
	public StrategyCallback getCallback() {
		return callback;
	}

	/**
	 * @param callback Callback to set
	 */
	public void setCallback(StrategyCallback callback) {
		this.callback = callback;
	}
}