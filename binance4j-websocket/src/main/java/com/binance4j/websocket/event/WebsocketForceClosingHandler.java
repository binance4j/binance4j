package com.binance4j.websocket.event;

import com.binance4j.core.event.TimeoutEvent;
import com.binance4j.websocket.callback.WebsocketCloseObject;
import com.binance4j.websocket.client.WebsocketClient;
import com.binance4j.websocket.client.WebsocketInterceptorCallback;

/**
 * Forces the call of the {@code onClosing} and {@code onClosed} event handlers
 * of {@link WebsocketClient
 * WebsocketClient's} {@link WebsocketInterceptorCallback}
 */
public class WebsocketForceClosingHandler extends BaseWebsocketEventHandler {
	/** Close object. */
	protected WebsocketCloseObject closeObject = new WebsocketCloseObject(-1000, "Client forced to close");

	/**
	 * @param websocketClient Websocket client.
	 * @param callback        Callback.
	 */
	public WebsocketForceClosingHandler(WebsocketClient websocketClient, WebsocketInterceptorCallback<?> callback) {
		super(websocketClient, callback, "Client not calling onClosing and onClosed event handlers", "Disconnected");
	}

	public void run() {
		cancel();
		eventHandler = new TimeoutEvent(websocketClient.getConfiguration().getDisconnectionTimeout(), () -> {
			if (!callback.isOnClosingCalled()) {
				callback.onClosing(closeObject);
				callback.onClosed(closeObject);
			}
		});
	}
}