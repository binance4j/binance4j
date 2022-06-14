package com.binance4j.strategy.trading;

import com.binance4j.core.exception.ApiException;
import com.binance4j.strategy.bar.SymbolBar;
import com.binance4j.websocket.client.WebsocketCloseObject;

import org.ta4j.core.BarSeries;

import io.reactivex.rxjava3.functions.Consumer;
import lombok.Getter;
import okhttp3.Response;

/**
 * An interface wrapping the response of a Binance API request
 */
@Getter
public class ApiStrategyCallback {
    /**
     * The callback to trigger when receiving a message from the websocket
     */
    private Consumer<SymbolBar> onMessageConsumer = (SymbolBar bar) -> {
    };

    /**
     * The callback to trigger when the strategy sends a BUY signal
     */
    private Consumer<BarSeries> onEnterConsumer = (BarSeries series) -> {
    };

    /**
     * The callback to trigger when the strategy sends a SELL signal
     */
    private Consumer<BarSeries> onExitConsumer = (BarSeries series) -> {
    };

    /**
     * The callback to trigger when the stream opens
     */
    private Consumer<Response> onOpenConsumer = (Response response) -> {
    };

    /**
     * The callback to trigger when the stream is closing
     */
    private Consumer<WebsocketCloseObject> onClosingConsumer = (WebsocketCloseObject closeObject) -> {
    };

    /**
     * The callback to trigger when the stream is closed
     */
    private Consumer<WebsocketCloseObject> onClosedConsumer = (WebsocketCloseObject closeObject) -> {
    };

    /**
     * The callback to trigger when the connection fails
     */
    private Consumer<ApiException> onFailureConsumer = (ApiException response) -> {
    };

    /**
     * Defines the callback to trigger when receiving a message from the websocket
     * 
     * @param callback The event callback
     */
    public void onMessage(Consumer<SymbolBar> callback) {
        this.onMessageConsumer = callback;
    }

    /**
     * Defines the callback to trigger when the strategy sends a BUY signal
     * 
     * @param callback The event callback
     */
    public void onEnter(Consumer<BarSeries> callback) {
        this.onEnterConsumer = callback;
    }

    /**
     * Defines the callback to trigger when the strategy sends a SELL signal
     * 
     * @param callback The event callback
     */
    public void onExit(Consumer<BarSeries> callback) {
        this.onExitConsumer = callback;
    }

    /**
     * Defines the callback to trigger when the stream opens
     * 
     * @param callback The event callback
     */
    public void onOpen(Consumer<Response> callback) {
        this.onOpenConsumer = callback;
    }

    /**
     * Defines the callback to trigger when the stream is closing
     * 
     * @param callback The event callback
     */
    public void onClosing(Consumer<WebsocketCloseObject> callback) {
        this.onClosingConsumer = callback;
    }

    /**
     * Defines the callback to trigger when the stream is closed
     * 
     * @param callback The event callback
     */
    public void onClosed(Consumer<WebsocketCloseObject> callback) {
        this.onClosedConsumer = callback;
    }

    /**
     * Defines the callback to trigger when the stream fails
     * 
     * @param callback The event callback
     */
    public void onFailure(Consumer<ApiException> callback) {
        this.onFailureConsumer = callback;
    }
}