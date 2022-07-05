package com.binance4j.websocket.event;

import com.binance4j.core.event.TimeoutEvent;
import com.binance4j.websocket.callback.WebsocketCloseObject;
import com.binance4j.websocket.client.WebsocketClient;
import com.binance4j.websocket.client.WebsocketInterceptorCallback;

/**
 * Forces the call of the {@code onClosing} and {@code onClosed} event handlers
 * of the {@link WebsocketClient WebsocketClient's}
 * {@link WebsocketInterceptorCallback}
 */
public class WebsocketForceClosingHandler extends BaseWebsocketEventHandler {
	protected WebsocketCloseObject closeObject = new WebsocketCloseObject(-1000, "Client forced to close");

	public WebsocketForceClosingHandler(WebsocketClient<?> websocketClient) {
		super(websocketClient, "Client not calling onClosing and onClosed event handlers", "Disconnected");
	}

	public void run() {
		cancel();

		eventHandler = new TimeoutEvent(
				websocketClient.getConfiguration().getDisconnectionTimeout(),
				() -> {
					if (!websocketClient.getInterceptorCallback().isOnClosingCalled()) {
						websocketClient.getInterceptorCallback().onClosing(closeObject);
						websocketClient.getInterceptorCallback().onClosed(closeObject);
					}
				});
	}
}