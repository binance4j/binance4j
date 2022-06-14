package com.binance4j.websocket.event;

import com.binance4j.websocket.client.WebsocketClient;

/**
 * Forces the closing of the client if it is stuck on closing state
 */
public class WebsocketDisconnectionHandler extends BaseWebsocketEventHandler {
	public WebsocketDisconnectionHandler(WebsocketClient<?> websocketClient) {
		super(websocketClient, "Client stuck in closing state", "Disconnected");
	}

	public void run() {
		cancel();
		disconnect(websocketClient.getConfiguration().getDisconnectionTimeout());
	}
}
