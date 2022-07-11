package com.binance4j.client;

import java.util.concurrent.CompletableFuture;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.callback.WebsocketCloseObject;
import com.binance4j.websocket.client.BaseWebsocketClient;

import lombok.Data;
import okhttp3.Response;

/**
 * Event handler callback.
 */
@Data
public class TestCallback<T> extends ConcurrentTest<Void> implements WebsocketCallback<T> {

	/**
	 * The CompletableFuture preventing the process to end before the tests
	 */
	protected CompletableFuture<Void> future;
	/**
	 * The ws client
	 */
	protected BaseWebsocketClient<T> websocketClient;

	/**
	 * @param client
	 */
	public TestCallback() {
		super();
		future = new CompletableFuture<>();
	}

	public void onMessage(Object response) {
		test(response);
		if (websocketClient != null) {
			websocketClient.close();
		}
	}

	public void onOpen(Response response) {
		test(response);
	}

	public void onFailure(ApiException exception) {
		System.out.println(exception.toString());
		test(exception);
		websocketClient.close();
		future.complete(null);
	}

	public void onClosing(WebsocketCloseObject websocketCloseObject) {
		test(websocketCloseObject);
	}

	public void onClosed(WebsocketCloseObject websocketCloseObject) {
		test(websocketCloseObject);
		future.complete(null);
	}
}
