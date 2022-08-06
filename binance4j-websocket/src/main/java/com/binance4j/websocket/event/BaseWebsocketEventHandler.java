package com.binance4j.websocket.event;

import java.time.Duration;

import com.binance4j.core.event.ScheduledEvent;
import com.binance4j.core.event.ScheduledTask;
import com.binance4j.core.event.TimeoutEvent;
import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.client.WebsocketClient;
import com.binance4j.websocket.client.WebsocketInterceptorCallback;

/** The base class of every {@link WebsocketEventHandler} */
public abstract class BaseWebsocketEventHandler implements WebsocketEventHandler {
	/** The websocket client handling this event handler. */
	protected final WebsocketClient websocketClient;
	/** The timeout ApiException. */
	protected final ApiException timeoutException;
	/** The disconnected ApiException. */
	protected final ApiException disconnectedException;
	/** The inner scheduled event. */
	protected ScheduledEvent eventHandler;
	/** The used callback. */
	protected WebsocketInterceptorCallback<?> callback;

	/**
	 * @param websocketClient Websocket client
	 * @param callback        Callback
	 */
	protected BaseWebsocketEventHandler(WebsocketClient websocketClient, WebsocketInterceptorCallback<?> callback) {
		this(websocketClient, callback, "Timeout", "Disconnected");
	}

	/**
	 * @param websocketClient     Websocket client
	 * @param callback            Callback
	 * @param timeoutMessage      Timeout message
	 * @param disconnectedMessage Disconnection message
	 */
	protected BaseWebsocketEventHandler(WebsocketClient websocketClient, WebsocketInterceptorCallback<?> callback, String timeoutMessage,
			String disconnectedMessage) {
		this.websocketClient = websocketClient;
		timeoutException = new ApiException(-1007, timeoutMessage);
		disconnectedException = new ApiException(-1001, disconnectedMessage);
		this.callback = callback;
	}

	public void cancel() {
		if (eventHandler != null) {
			eventHandler.cancel();
		}
	}

	public void disconnect(Duration timeout) {
		ScheduledTask timeoutTask = () -> {
			callback.onFailure(disconnectedException);
			websocketClient.close(false);
		};
		eventHandler = new TimeoutEvent(timeout, timeoutTask);
	}
}
