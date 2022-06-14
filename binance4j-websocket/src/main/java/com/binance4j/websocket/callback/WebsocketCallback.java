package com.binance4j.websocket.callback;

import com.binance4j.core.exception.ApiException;
import okhttp3.Response;

/**
 * Websocket client stream events handler
 */
@FunctionalInterface
public interface WebsocketCallback<T> {
	/**
	 * Triggered when the server sends data
	 *
	 * @param message The server message
	 */
	void onMessage(T message);

	/**
	 * Triggered when the connection fails
	 *
	 * @param exception The Exception containing the API code and message error.
	 */
	default void onFailure(ApiException exception) {
	}

	/**
	 * Triggered when the connection is closing
	 *
	 * @param websocketCloseObject Websocket closing code and reason container
	 */
	default void onClosing(WebsocketCloseObject websocketCloseObject) {
	}

	/**
	 * Triggered when the connection is closed
	 *
	 * @param websocketCloseObject Websocket closing code and reason container
	 */
	default void onClosed(WebsocketCloseObject websocketCloseObject) {
	}

	/**
	 * Triggered when the connection is opened
	 *
	 * @param response The API open response
	 */
	default void onOpen(Response response) {
	}
}