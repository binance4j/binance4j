package com.binance4j.websocket.event;

import com.binance4j.websocket.client.WebsocketClient;
import com.binance4j.websocket.client.WebsocketInterceptorCallback;
import com.binance4j.websocket.configuration.WebsocketClientConfiguration;

/**
 * Disconnects the client if no data was received in the interval defined by
 * {@link WebsocketClientConfiguration#getNoResponseTimeout()}
 */
public class WebsocketNoResponseHandler extends BaseWebsocketEventHandler {
	public WebsocketNoResponseHandler(WebsocketClient websocketClient, WebsocketInterceptorCallback<?> callback) {
		super(websocketClient, callback, "No response from the server", "Disconnected");
	}

	public void run() {
		cancel();
		disconnect(websocketClient.getConfiguration().getNoResponseTimeout());
	}
}
