package com.binance4j.strategy;

import org.ta4j.core.BarSeries;

import com.binance4j.core.exception.ApiException;
import com.binance4j.strategy.dto.SymbolBar;
import com.binance4j.websocket.callback.WebsocketCloseObject;

import okhttp3.Response;

/** Strategy and stream handler. */
public interface StrategyCallback {

	/**
	 * Triggered when the strategy sends a BUY message.
	 * 
	 * @param series Bar series we are working on.
	 */
	public void onEnter(BarSeries series);

	/**
	 * Triggered when the strategy sends a SELL message.
	 * 
	 * @param series Bar series we are working on.
	 */
	public void onExit(BarSeries series);

	/**
	 * Triggered when receiving a bar.
	 * 
	 * @param symbolBar Last ohlcv bar.
	 */
	default void onMessage(SymbolBar symbolBar) {
	}

	/**
	 * Triggered when stream is open.
	 * 
	 * @param response Opening response.
	 */
	default void onOpen(Response response) {
	}

	/**
	 * Triggered when stream is closing.
	 * 
	 * @param closeObject close object.
	 */
	default void onClosing(WebsocketCloseObject closeObject) {
	}

	/**
	 * Triggered when stream is closed.
	 * 
	 * @param closeObject close object.
	 */
	default void onClosed(WebsocketCloseObject closeObject) {
	}

	/**
	 * Something went wrong.
	 * 
	 * @param apiException Thrown exception.
	 */
	default void onFailure(ApiException apiException) {
	}
}