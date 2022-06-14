package com.binance4j.websocket.event;

import com.binance4j.core.event.IntervalEvent;
import com.binance4j.core.event.ScheduledTask;
import com.binance4j.websocket.client.WebsocketClient;
import com.binance4j.websocket.configuration.WebsocketClientConfiguration;

import java.time.Duration;

/**
 * Reconnects or disconnects the client according to
 * {@link WebsocketClientConfiguration#getReconnectionInterval()} and
 * {@link WebsocketClientConfiguration#getMaxReconnections()}
 */
public class WebsocketConnectionHandler extends BaseWebsocketEventHandler {
	public WebsocketConnectionHandler(WebsocketClient<?> websocketClient) {
		super(websocketClient, "Connection failed", "Connection failed too many times");
	}

	public void run() {
		cancel();

		Duration reconnectionInterval = websocketClient.getConfiguration().getReconnectionInterval();
		Duration timeoutInterval = websocketClient.getConfiguration().getReconnectionInterval();
		int maxReconnection = websocketClient.getConfiguration().getMaxReconnections();

		ScheduledTask reconnectTask = () -> {
			websocketClient.getCallback().onFailure(timeoutException);

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
