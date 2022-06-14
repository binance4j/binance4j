package com.binance4j.strategy.trading;

import com.binance4j.core.exception.ApiException;
import com.binance4j.strategy.bar.SymbolBar;
import com.binance4j.websocket.callback.GenericCallback;
import com.binance4j.websocket.callback.WebsocketCloseObject;
import lombok.Getter;
import okhttp3.Response;
import org.ta4j.core.BarSeries;

/**
 * Strategy Callback to handle stream events
 */
@Getter
public class StrategyCallback {
	/**
	 * The callback to trigger when receiving a message from the websocket
	 */
	private GenericCallback<SymbolBar> onMessageConsumer = (SymbolBar bar) -> {
	};

	/**
	 * The callback to trigger when the strategy sends a BUY signal
	 */
	private GenericCallback<BarSeries> onEnterConsumer = (BarSeries series) -> {
	};

	/**
	 * The callback to trigger when the strategy sends a SELL signal
	 */
	private GenericCallback<BarSeries> onExitConsumer = (BarSeries series) -> {
	};

	/**
	 * The callback to trigger when the stream opens
	 */
	private GenericCallback<Response> onOpenConsumer = (Response response) -> {
	};

	/**
	 * The callback to trigger when the stream is closing
	 */
	private GenericCallback<WebsocketCloseObject> onClosingConsumer = (WebsocketCloseObject closeObject) -> {
	};

	/**
	 * The callback to trigger when the stream is closed
	 */
	private GenericCallback<WebsocketCloseObject> onClosedConsumer = (WebsocketCloseObject closeObject) -> {
	};

	/**
	 * The callback to trigger when the connection fails
	 */
	private GenericCallback<ApiException> onFailureConsumer = (ApiException response) -> {
	};

	/**
	 * Defines the callback to trigger when receiving a message from the websocket
	 *
	 * @param callback The event callback
	 */
	public void onMessage(GenericCallback<SymbolBar> callback) {
		this.onMessageConsumer = callback;
	}

	/**
	 * Defines the callback to trigger when the strategy sends a BUY signal
	 *
	 * @param callback The event callback
	 */
	public void onEnter(GenericCallback<BarSeries> callback) {
		this.onEnterConsumer = callback;
	}

	/**
	 * Defines the callback to trigger when the strategy sends a SELL signal
	 *
	 * @param callback The event callback
	 */
	public void onExit(GenericCallback<BarSeries> callback) {
		this.onExitConsumer = callback;
	}

	/**
	 * Defines the callback to trigger when the stream opens
	 *
	 * @param callback The event callback
	 */
	public void onOpen(GenericCallback<Response> callback) {
		this.onOpenConsumer = callback;
	}

	/**
	 * Defines the callback to trigger when the stream is closing
	 *
	 * @param callback The event callback
	 */
	public void onClosing(GenericCallback<WebsocketCloseObject> callback) {
		this.onClosingConsumer = callback;
	}

	/**
	 * Defines the callback to trigger when the stream is closed
	 *
	 * @param callback The event callback
	 */
	public void onClosed(GenericCallback<WebsocketCloseObject> callback) {
		this.onClosedConsumer = callback;
	}

	/**
	 * Defines the callback to trigger when the stream fails
	 *
	 * @param callback The event callback
	 */
	public void onFailure(GenericCallback<ApiException> callback) {
		this.onFailureConsumer = callback;
	}
}