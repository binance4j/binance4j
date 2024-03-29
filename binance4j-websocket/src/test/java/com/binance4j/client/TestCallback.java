package com.binance4j.client;

import java.util.concurrent.CompletableFuture;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;
import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.callback.WebsocketCloseObject;
import com.binance4j.websocket.client.BaseWebsocketClient;

import okhttp3.Response;

/** Event handler callback. */
public class TestCallback<T> extends CustomTest implements WebsocketCallback<T> {
	/** The CompletableFuture preventing the process to end before the tests. */
	protected CompletableFuture<Void> future;
	/** The ws client. */
	protected BaseWebsocketClient<T> websocketClient;

	/** @param client. */
	public TestCallback() {
		super();
		future = new CompletableFuture<>();
	}

	public void onMessage(Object response) {
		testNoNulls(response);
		if (websocketClient != null) {
			websocketClient.close();
		}
	}

	public void onOpen(Response response) {
		testNoNulls(response);
	}

	public void onFailure(ApiException exception) {
		testNoNulls(exception);
		websocketClient.close();
		future.complete(null);
	}

	public void onClosing(WebsocketCloseObject websocketCloseObject) {
		testNoNulls(websocketCloseObject);
	}

	public void onClosed(WebsocketCloseObject websocketCloseObject) {
		testNoNulls(websocketCloseObject);
		future.complete(null);
	}

	/**
	 * @return the future.
	 */
	public CompletableFuture<Void> getFuture() {
		return future;
	}

	/**
	 * @param future Future to set.
	 */
	public void setFuture(CompletableFuture<Void> future) {
		this.future = future;
	}

	/**
	 * @return the websocketClient.
	 */
	public BaseWebsocketClient<T> getWebsocketClient() {
		return websocketClient;
	}

	/**
	 * @param websocketClient WebsocketClient to set.
	 */
	public void setWebsocketClient(BaseWebsocketClient<T> websocketClient) {
		this.websocketClient = websocketClient;
	}
}
