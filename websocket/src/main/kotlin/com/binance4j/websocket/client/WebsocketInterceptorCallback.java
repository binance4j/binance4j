package com.binance4j.websocket.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.callback.WebsocketCloseObject;
import com.binance4j.websocket.event.WebsocketConnectionHandler;
import com.binance4j.websocket.event.WebsocketDisconnectionHandler;
import com.binance4j.websocket.event.WebsocketEventHandler;
import com.binance4j.websocket.event.WebsocketNoResponseHandler;

import okhttp3.Response;
import okhttp3.WebSocket;

/**
 * Interceptor callback for {@link WebsocketClient} main callback to handle
 * event failures
 */
public class WebsocketInterceptorCallback<T> :WebsocketCallback<T>
{
	/** The main ws client. */
	protected WebsocketClient websocketClient;
	/** Event to handle connection failure and try to reconnect. */
	protected WebsocketEventHandler connectionHandler;
	/** Event to handle no response from server. */
	protected WebsocketEventHandler noResponseHandler;
	/** Event to handle failure in the disconnection state. */
	protected WebsocketEventHandler disconnectionHandler;
	/** Forces the call of onClosing and onClosed. */
	protected WebsocketEventHandler forceClosingHandler;
	/** The inner callback. */
	protected WebsocketCallback<T> callback;
	/** Tells the interceptor if the closing has been made by the client. */
	boolean closedByClient;
	/** Has the onClosing handler been called. */
	boolean onClosingCalled;
	/** THe socket using the callback. */
	WebSocket socket;

	/**
	 * @param websocketClient Main ws client.
	 * @param callback        Callback.
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
		callback.onClosed(closeObject); // Reconnect if server closed stream and keepAlive is on
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

	/**
	 * @return the onClosingCalled
	 */
	public boolean isOnClosingCalled() {
		return onClosingCalled;
	}

	/**
	 * @param onClosingCalled OnClosingCalled to set
	 */
	public void setOnClosingCalled(boolean onClosingCalled) {
		this.onClosingCalled = onClosingCalled;
	}

	/**
	 * @return the socket
	 */
	public WebSocket getSocket() {
		return socket;
	}

	/**
	 * @param socket Socket to set
	 */
	public void setSocket(WebSocket socket) {
		this.socket = socket;
	}

	/**
	 * @return the websocketClient
	 */
	public WebsocketClient getWebsocketClient() {
		return websocketClient;
	}

	/**
	 * @param websocketClient WebsocketClient to set
	 */
	public void setWebsocketClient(WebsocketClient websocketClient) {
		this.websocketClient = websocketClient;
	}

	/**
	 * @return the connectionHandler
	 */
	public WebsocketEventHandler getConnectionHandler() {
		return connectionHandler;
	}

	/**
	 * @param connectionHandler ConnectionHandler to set
	 */
	public void setConnectionHandler(WebsocketEventHandler connectionHandler) {
		this.connectionHandler = connectionHandler;
	}

	/**
	 * @return the noResponseHandler
	 */
	public WebsocketEventHandler getNoResponseHandler() {
		return noResponseHandler;
	}

	/**
	 * @param noResponseHandler NoResponseHandler to set
	 */
	public void setNoResponseHandler(WebsocketEventHandler noResponseHandler) {
		this.noResponseHandler = noResponseHandler;
	}

	/**
	 * @return the disconnectionHandler
	 */
	public WebsocketEventHandler getDisconnectionHandler() {
		return disconnectionHandler;
	}

	/**
	 * @param disconnectionHandler DisconnectionHandler to set
	 */
	public void setDisconnectionHandler(WebsocketEventHandler disconnectionHandler) {
		this.disconnectionHandler = disconnectionHandler;
	}

	/**
	 * @return the forceClosingHandler
	 */
	public WebsocketEventHandler getForceClosingHandler() {
		return forceClosingHandler;
	}

	/**
	 * @param forceClosingHandler ForceClosingHandler to set
	 */
	public void setForceClosingHandler(WebsocketEventHandler forceClosingHandler) {
		this.forceClosingHandler = forceClosingHandler;
	}

	/**
	 * @return the callback
	 */
	public WebsocketCallback<T> getCallback() {
		return callback;
	}

	/**
	 * @param callback Callback to set
	 */
	public void setCallback(WebsocketCallback<T> callback) {
		this.callback = callback;
	}

	/**
	 * @return the closedByClient
	 */
	public boolean isClosedByClient() {
		return closedByClient;
	}

	/**
	 * @param closedByClient ClosedByClient to set
	 */
	public void setClosedByClient(boolean closedByClient) {
		this.closedByClient = closedByClient;
	}
}