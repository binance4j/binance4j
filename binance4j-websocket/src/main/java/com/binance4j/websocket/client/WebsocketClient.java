package com.binance4j.websocket.client;

import com.binance4j.websocket.configuration.WebsocketClientConfiguration;

/**
 * A websocket client
 */
public interface WebsocketClient {

	/**
	 * Opens the stream
	 */
	void open();

	/**
	 * Forces the closing of the stream
	 */
	void close();

	/**
	 * Closes of the stream
	 * 
	 * @param force force the closing?
	 */
	void close(boolean force);

	/**
	 * The client configuration
	 */
	WebsocketClientConfiguration getConfiguration();
}
