package com.binance4j.websocket.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.callback.WebsocketCloseObject;
import com.binance4j.websocket.event.WebsocketConnectionHandler;
import com.binance4j.websocket.event.WebsocketDisconnectionHandler;
import com.binance4j.websocket.event.WebsocketNoResponseHandler;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import okhttp3.Response;

/**
 * Interceptor callback for the {@link WebsocketClient} main callback to handle
 * event failures
 */
@Data
public class WebsocketInterceptorCallback<T> implements WebsocketCallback<T> {
	/**
	 * The main ws client
	 */
	WebsocketClient<T> websocketClient;
	/**
	 * Event to handle connection failure and try to reconnect
	 */
	@Getter(value = AccessLevel.PROTECTED)
	private WebsocketConnectionHandler connectionHandler;
	/**
	 * Event to handle no response from server
	 */
	@Getter(value = AccessLevel.PROTECTED)
	private WebsocketNoResponseHandler noResponseHandler;
	/**
	 * Event to handle failure in the disconnection state
	 */
	@Getter(value = AccessLevel.PROTECTED)
	private WebsocketDisconnectionHandler disconnectionHandler;
	/**
	 * Tells the interceptor if th e closing has been made by the client
	 */
	private boolean closedByClient;

	/**
	 * Constructor
	 *
	 * @param websocketClient The main ws client
	 */
	public WebsocketInterceptorCallback(WebsocketClient<T> websocketClient) {
		this.websocketClient = websocketClient;
		connectionHandler = new WebsocketConnectionHandler(websocketClient);
		noResponseHandler = new WebsocketNoResponseHandler(websocketClient);
		disconnectionHandler = new WebsocketDisconnectionHandler(websocketClient);
	}

	@Override
	public void onMessage(T payload) {
		noResponseHandler.run();
		websocketClient.getCallback().onMessage(payload);
	}

	@Override
	public void onClosing(WebsocketCloseObject closeObject) {
		// we force disconnection
		disconnectionHandler.run();
		websocketClient.getCallback().onClosing(closeObject);
	}

	@Override
	public void onClosed(WebsocketCloseObject closeObject) {
		// we stop disconnection forcing
		disconnectionHandler.cancel();
		websocketClient.getCallback().onClosed(closeObject);

		// Reconnect if server closed stream and keepAlive is on
		if (websocketClient.getConfiguration().isKeepAlive() && !closedByClient) {
			websocketClient.open();
		}
	}

	@Override
	public void onOpen(Response response) {
		// we stop trying to reconnect
		connectionHandler.cancel();
		// we handle no response data
		noResponseHandler.run();

		websocketClient.getCallback().onOpen(response);
	}

	@Override
	public void onFailure(ApiException exception) {
		websocketClient.getCallback().onFailure(exception);
	}
}