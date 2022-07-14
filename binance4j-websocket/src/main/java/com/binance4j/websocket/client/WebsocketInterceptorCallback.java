package com.binance4j.websocket.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.callback.WebsocketCloseObject;
import com.binance4j.websocket.event.WebsocketConnectionHandler;
import com.binance4j.websocket.event.WebsocketDisconnectionHandler;
import com.binance4j.websocket.event.WebsocketEventHandler;
import com.binance4j.websocket.event.WebsocketNoResponseHandler;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import okhttp3.Response;
import okhttp3.WebSocket;

/**
 * Interceptor callback for the {@link WebsocketClient} main callback to handle
 * event failures
 */
@Data
public class WebsocketInterceptorCallback<T> implements WebsocketCallback<T> {
	/** The main ws client. */
	WebsocketClient websocketClient;
	/** Event to handle connection failure and try to reconnect. */
	@Getter(value = AccessLevel.PROTECTED)
	private WebsocketEventHandler connectionHandler;
	/** Event to handle no response from server. */
	@Getter(value = AccessLevel.PROTECTED)
	private WebsocketEventHandler noResponseHandler;
	/** Event to handle failure in the disconnection state. */
	@Getter(value = AccessLevel.PROTECTED)
	private WebsocketEventHandler disconnectionHandler;

	/** Forces the call of onClosing and onClosed. */
	@Getter(value = AccessLevel.PROTECTED)
	private WebsocketEventHandler forceClosingHandler;

	/** Tells the interceptor if th e closing has been made by the client. */
	private boolean closedByClient;

	/** Has the onClosing handler been called. */
	private boolean onClosingCalled;

	@Getter(AccessLevel.NONE)
	private WebSocket socket;

	protected WebsocketCallback<T> callback;

	/**
	 *
	 * 
	 * @param websocketClient The main ws client
	 */
	public WebsocketInterceptorCallback(WebsocketClient websocketClient, WebsocketCallback<T> callback) {
		this.websocketClient = websocketClient;
		connectionHandler = new WebsocketConnectionHandler(websocketClient, this);
		noResponseHandler = new WebsocketNoResponseHandler(websocketClient, this);
		disconnectionHandler = new WebsocketDisconnectionHandler(websocketClient, this);
		this.callback = callback;
	}

	@Override
	public void onMessage(T payload) {
		noResponseHandler.run();
		callback.onMessage(payload);
	}

	@Override
	public void onClosing(WebsocketCloseObject closeObject) {
		if (forceClosingHandler != null) {
			forceClosingHandler.cancel();
		}
		onClosingCalled = true;
		// we force disconnection
		disconnectionHandler.run();
		callback.onClosing(closeObject);
	}

	@Override
	public void onClosed(WebsocketCloseObject closeObject) {
		// we stop disconnection forcing
		disconnectionHandler.cancel();
		callback.onClosed(closeObject);

		// Reconnect if server closed stream and keepAlive is on
		if (websocketClient.getConfiguration().isKeepAlive() && !closedByClient) {
			websocketClient.open();
		}

		socket = null;
	}

	@Override
	public void onOpen(Response response) {
		// we stop trying to reconnect
		connectionHandler.cancel();
		// we handle no response data
		noResponseHandler.run();

		callback.onOpen(response);
	}

	@Override
	public void onFailure(ApiException exception) {
		callback.onFailure(exception);
	}
}