package com.binance4j.strategy.trading;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.market.Candle;
import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.strategy.backtesting.BackTestResult;
import com.binance4j.strategy.bar.SymbolBar;
import com.binance4j.strategy.service.BarSeriesService;
import com.binance4j.strategy.service.BarService;
import com.binance4j.vision.spot.VisionSpotClient;
import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.callback.WebsocketCloseObject;
import com.binance4j.websocket.candle.CandlePayload;
import com.binance4j.websocket.candle.WebsocketCandlestickClient;
import com.binance4j.websocket.service.DurationService;
import lombok.Getter;
import okhttp3.Response;
import org.ta4j.core.*;

import java.time.Duration;
import java.time.ZoneId;
import java.util.*;

/**
 * The abstract implementation of {@link TradingStrategy} any trading strategy
 * should inherit.
 */
public abstract class BaseTradingStrategy implements TradingStrategy {
	/**
	 * The websocket client
	 */
	private WebsocketCandlestickClient wsClient;

	/**
	 * The series used in watch mode
	 */
	private Map<String, BarSeries> barSeries;

	/**
	 * The BarSeries max size. Default 500
	 */
	@Getter
	private int maximumBarCount = 500;

	/**
	 * Updates all the series max size, preventing memory overload
	 *
	 * @param maximumBarCount The series size
	 */
	public void setMaximumBarCount(int maximumBarCount) {
		this.maximumBarCount = maximumBarCount;
		barSeries.values().forEach(series -> series.setMaximumBarCount(maximumBarCount));
	}

	/* Analysing */

	// BarSeries
	@Override
	public boolean shouldEnter(BarSeries series, int index) {
		return buildStrategy(series).shouldEnter(index);
	}

	@Override
	public boolean shouldEnter(BarSeries series) {
		return shouldEnter(series, series.getBarCount() - 1);
	}

	@Override
	public boolean shouldExit(BarSeries series, int index) {
		return buildStrategy(series).shouldExit(index);
	}

	@Override
	public boolean shouldExit(BarSeries series) {
		return shouldExit(series, series.getBarCount() - 1);
	}

	// CandlestickBars

	@Override
	public boolean shouldEnter(List<Candle> bars, CandlestickInterval interval, int index) {
		return shouldEnter(BarSeriesService.convert(bars, interval), index);
	}

	@Override
	public boolean shouldEnter(List<Candle> bars, CandlestickInterval interval) {
		return shouldEnter(BarSeriesService.convert(bars, interval));
	}

	@Override
	public boolean shouldExit(List<Candle> bars, CandlestickInterval interval, int index) {
		return shouldExit(BarSeriesService.convert(bars, interval), index);
	}

	@Override
	public boolean shouldExit(List<Candle> bars, CandlestickInterval interval) {
		return shouldExit(BarSeriesService.convert(bars, interval));
	}

	/* Live trading */

	@Override
	public WebsocketCandlestickClient watch(String symbols, CandlestickInterval interval, ZoneId zoneId,
	                                        StrategyCallback callback) {
		barSeries = new HashMap<>();

		// let's initialize a BarSeries for each symbol with the symbol as name of the
		// series and a limit size
		Arrays.stream(symbols.split(",")).map(String::trim).forEach(symbol -> {
			BarSeries bar = new BaseBarSeries(symbol);
			bar.setMaximumBarCount(maximumBarCount);
			barSeries.put(symbol, bar);
		});

		Duration duration = DurationService.convert(interval);

		wsClient = new WebsocketCandlestickClient(symbols, interval, new WebsocketCallback<CandlePayload>() {
			public void onMessage(CandlePayload response) {
				// let's convert the bar and give it the symbol name
				Bar bar = BarService.convert(response, duration, zoneId);
				callback.getOnMessageConsumer().call(new SymbolBar(bar, response.getSymbol()));

				// we determinate what method to call according to the strategy
				if (response.getIsBarFinal()) {
					BarSeries series = barSeries.get(response.getSymbol());
					series.addBar(bar);
					int lastIndex = series.getBarCount() - 1;
					// we add the bar to the series
					Strategy strategy = buildStrategy(series);
					if (strategy.shouldEnter(lastIndex)) {
						callback.getOnEnterConsumer().call(series);
					} else if (strategy.shouldExit(lastIndex)) {
						callback.getOnExitConsumer().call(series);
					}
				}
			}

			@Override
			public void onOpen(Response response) {
				callback.getOnOpenConsumer().call(response);
			}

			@Override
			public void onClosed(WebsocketCloseObject websocketCloseObject) {
				callback.getOnClosedConsumer().call(websocketCloseObject);
			}

			@Override
			public void onClosing(WebsocketCloseObject websocketCloseObject) {
				callback.getOnClosingConsumer().call(websocketCloseObject);
			}

			@Override
			public void onFailure(ApiException exception) {
				callback.getOnFailureConsumer().call(exception);
			}
		});

		wsClient.open();

		return wsClient;
	}

	@Override
	public WebsocketCandlestickClient watch(Collection<String> symbols, CandlestickInterval interval, ZoneId zoneId,
	                                        StrategyCallback callback) {
		return watch(String.join(",", symbols), interval, zoneId, callback);
	}

	@Override
	public WebsocketCandlestickClient watch(String symbols, CandlestickInterval interval,
	                                        StrategyCallback callback) {
		return watch(symbols, interval, ZoneId.systemDefault(), callback);
	}

	@Override
	public WebsocketCandlestickClient watch(Collection<String> symbols, CandlestickInterval interval,
	                                        StrategyCallback callback) {
		return watch(String.join(",", symbols), interval, callback);
	}

	@Override
	public void unwatch() {
		if (wsClient != null)
			wsClient.close();
	}

	/* Backtest */

	@Override
	public BackTestResult backTest(BarSeries series) {
		return new BackTestResult(series, new BarSeriesManager(series).run(buildStrategy(series)));
	}

	@Override
	public BackTestResult backTest(List<Candle> bars, CandlestickInterval interval) {
		return backTest(BarSeriesService.convert(bars, DurationService.convert(interval)));
	}

	@Override
	public BackTestResult backTest(String symbol, CandlestickInterval interval, String year,
	                               String month) throws ApiException {
		List<Candle> bars = new VisionSpotClient().getKlines(symbol, interval, year, month).getData();
		return backTest(bars, interval);
	}

	@Override
	public BackTestResult backTest(String symbol, CandlestickInterval interval, String year,
	                               String month, String day) throws ApiException {
		List<Candle> bars = new VisionSpotClient().getKlines(symbol, interval, year, month, day).getData();
		return backTest(bars, interval);
	}

	/* Strategy building */

	/**
	 * Builds the trading strategy with the two defined rules
	 *
	 * @param series The {@link BarSeries}
	 * @return The generated t4j {@link Strategy}
	 */
	private Strategy buildStrategy(BarSeries series) {
		Rule enterRule = getEntry(series);
		Rule exitRule = getExit(series);

		if (enterRule == null || exitRule == null) {
			throw new NullPointerException("Rules cannot be null");
		}

		return new BaseStrategy(enterRule, exitRule);
	}
}