package com.binance4j.websocket.event;

import java.time.Duration;

import com.binance4j.core.event.IntervalEvent;
import com.binance4j.core.event.ScheduledTask;
import com.binance4j.websocket.client.WebsocketClient;
import com.binance4j.websocket.client.WebsocketInterceptorCallback;
import com.binance4j.websocket.configuration.WebsocketClientConfiguration;

/**
 * Reconnects or disconnects the client according to
 * [WebsocketClientConfiguration.getReconnectionInterval] and
 * [WebsocketClientConfiguration.getMaxReconnections]
 */
public class WebsocketConnectionHandler extends BaseWebsocketEventHandler {
	/**
	 * @param websocketClient Websocket client.
	 * @param callback        Callback.
	 */
	public WebsocketConnectionHandler(WebsocketClient websocketClient, WebsocketInterceptorCallback<?> callback) {
		super(websocketClient, callback, "Connection failed", "Connection failed too many times");
	}

	public void run() {
		cancel();
		Duration reconnectionInterval = websocketClient.getConfiguration().getReconnectionInterval();
		Duration timeoutInterval = websocketClient.getConfiguration().getReconnectionInterval();
		int maxReconnection = websocketClient.getConfiguration().getMaxReconnections();
		ScheduledTask reconnectTask = () -> {
			callback.onFailure(timeoutException);
			if (eventHandler.isFinalTick()) {
				disconnect(timeoutInterval);
			} else {
				disconnect(Duration.ofSeconds(0));
				websocketClient.open();
			}
		};
		eventHandler = new IntervalEvent(reconnectionInterval, maxReconnection, reconnectTask);
	}
}
