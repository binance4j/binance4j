package com.binance4j.websocket.event;

import com.binance4j.websocket.client.WebsocketClient;
import com.binance4j.websocket.client.WebsocketInterceptorCallback;

/** Forces the closing of the client if it is stuck on closing state */
public class WebsocketDisconnectionHandler extends BaseWebsocketEventHandler {
	/**
	 * @param websocketClient Websocket client.
	 * @param callback        Callback.
	 */
	public WebsocketDisconnectionHandler(WebsocketClient websocketClient, WebsocketInterceptorCallback<?> callback) {
		super(websocketClient, callback, "Client not closing", "Disconnected");
	}

	public void run() {
		cancel();
		disconnect(websocketClient.getConfiguration().getDisconnectionTimeout());
	}
}
