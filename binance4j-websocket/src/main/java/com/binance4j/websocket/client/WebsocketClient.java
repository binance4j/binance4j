package com.binance4j.websocket.client;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.configuration.WebsocketClientConfiguration;

/**
 * A websocket client
 */
public interface WebsocketClient<T> {

	/**
	 * Opens the stream
	 */
	void open();

	/**
	 * Forces the closing of the stream
	 */
	void close();

	/**
	 * The client configuration
	 */
	WebsocketClientConfiguration getConfiguration();

	/**
	 * The inner stream events handler
	 */
	WebsocketCallback<T> getCallback();

	/**
	 * The main stream events handler
	 */
	WebsocketInterceptorCallback<T> getInterceptorCallback();
}
