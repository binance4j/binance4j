package com.binance4j.websocket.event;

import java.time.Duration;

import com.binance4j.core.event.ScheduledEvent;
import com.binance4j.core.event.ScheduledTask;
import com.binance4j.core.event.TimeoutEvent;
import com.binance4j.core.exception.ApiErrorCode;
import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.client.WebsocketClient;

public abstract class BaseWebsocketEventHandler implements WebsocketEventHandler {
	protected final WebsocketClient<?> websocketClient;
	protected final ApiException timeoutException;
	protected final ApiException disconnectedException;
	protected ScheduledEvent eventHandler;

	protected BaseWebsocketEventHandler(WebsocketClient<?> websocketClient) {
		this(websocketClient, "Timeout", "Disconnected");
	}

	protected BaseWebsocketEventHandler(WebsocketClient<?> websocketClient, String timeoutMessage,
			String disconnectedMessage) {
		this.websocketClient = websocketClient;
		timeoutException = new ApiException(ApiErrorCode.TIMEOUT, timeoutMessage);
		disconnectedException = new ApiException(ApiErrorCode.DISCONNECTED, disconnectedMessage);
	}

	public void cancel() {
		if (eventHandler != null)
			eventHandler.cancel();
	}

	public void disconnect(Duration timeout) {
		ScheduledTask timeoutTask = () -> {
			websocketClient.getCallback().onFailure(disconnectedException);
			websocketClient.close();
		};

		eventHandler = new TimeoutEvent(timeout, timeoutTask);
	}
}
