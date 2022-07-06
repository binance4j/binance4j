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

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.strategy.TradingStrategy;
import com.binance4j.strategy.dto.StrategyCallback;
import com.binance4j.strategy.dto.SymbolBar;
import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.callback.WebsocketCloseObject;
import com.binance4j.websocket.candle.CandlePayload;
import com.binance4j.websocket.candle.WebsocketCandlestickClient;
import com.binance4j.websocket.configuration.WebsocketClientConfiguration;
import com.binance4j.websocket.service.DurationService;

import lombok.Data;
import okhttp3.Response;

/** Service to live trade a {@link TradingStrategy} */
@Data
public class WatchService {

    /**
     * The websocket client configuration
     */
    private WebsocketClientConfiguration configuration;

    /**
     * The BarSeries max size. Default 500
     */
    private int maximumBarCount = 500;

    /**
     * The websocket client
     */
    protected WebsocketCandlestickClient wsClient;

    /**
     * The series used in watch mode
     */
    protected Map<String, BarSeries> barSeries;

    protected TradingStrategy tradingStrategy;

    /**
     * Constructor
     * 
     * @param strategy The strategy used to live trade
     */
    public WatchService(TradingStrategy strategy) {
        this.tradingStrategy = strategy;
        configuration = new WebsocketClientConfiguration();
    }

    /**
     * Updates all the series max size, preventing memory overload
     *
     * @param maximumBarCount The series size
     */
    public void setMaximumBarCount(int maximumBarCount) {
        this.maximumBarCount = maximumBarCount;
        barSeries.values().forEach(series -> series.setMaximumBarCount(maximumBarCount));
    }

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

                callback.getOnMessageConsumer().call(new SymbolBar(bar, response.isBarFinal(),response.getSymbol()));

                // we determinate what method to call according to the strategy
                if (response.isBarFinal()) {
                    BarSeries series = barSeries.get(response.getSymbol());
                    series.addBar(bar);
                    int lastIndex = series.getBarCount() - 1;
                    // we add the bar to the series
                    Strategy strategy = StrategyBuilder.build(tradingStrategy, series);
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

        wsClient.setConfiguration(configuration);
        wsClient.open();
        return wsClient;
    }

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
    public WebsocketCandlestickClient watch(Collection<String> symbols, CandlestickInterval interval, ZoneId zoneId,
            StrategyCallback callback) {
        return watch(String.join(",", symbols), interval, zoneId, callback);
    }

    /**
     * Listens to the Klines websocket endpoint and runs the strategy over the
     * received {@link BarSeries} with {@link ZoneId#systemDefault()}
     *
     * @param symbols  The symbols to listen to
     * @param interval The candlestick interval
     * @param callback The methods to call according to the server response
     * @return The websocket client connected to the server
     */
    public WebsocketCandlestickClient watch(String symbols, CandlestickInterval interval,
            StrategyCallback callback) {
        return watch(symbols, interval, ZoneId.systemDefault(), callback);
    }

    /**
     * Listens to the Klines websocket endpoint and runs the strategy over the
     * received {@link BarSeries} with {@link ZoneId#systemDefault()}
     *
     * @param symbols  The symbols to listen to
     * @param interval The candlestick interval
     * @param callback The methods to call according to the server response
     * @return The websocket client connected to the server
     */
    public WebsocketCandlestickClient watch(Collection<String> symbols, CandlestickInterval interval,
            StrategyCallback callback) {
        return watch(String.join(",", symbols), interval, callback);
    }

    /**
     * Closes the websocket transaction
     */
    public void unwatch() {
        if (wsClient != null)
            wsClient.close();
    }
}