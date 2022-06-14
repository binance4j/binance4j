package com.binance4j.utils;

import java.util.concurrent.CompletableFuture;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.callback.WebsocketCloseObject;
import com.binance4j.websocket.client.BaseWebsocketClient;

import lombok.Data;
import okhttp3.Response;

/**
 * Event handler callback.
 */
@Data
public class TestCallback<T> implements WebsocketCallback<T> {
	/**
	 * The server responses
	 */
	private TestCallbackContent<T> content = new TestCallbackContent<>();
	/**
	 * The CompletableFuture preventing the process to end before the tests
	 */
	private CompletableFuture<Void> future;
	/**
	 * The ws client
	 */
	private BaseWebsocketClient<T> client;

	@Override
	public void onClosing(WebsocketCloseObject websocketCloseObject) {

		content.setOnClosingContent(websocketCloseObject);
	}

	@Override
	public void onClosed(WebsocketCloseObject websocketCloseObject) {

		content.setOnClosedContent(websocketCloseObject);
		future.complete(null);
	}

	@Override
	public void onOpen(Response response) {

		content.setOnOpenContent(response);
	}

	@Override
	public void onFailure(ApiException exception) {

		content.setOnFailureContent(exception);
		client.close();
	}

	@Override
	public void onMessage(T response) {

		content.setOnMessageContent(response);
		client.close();
	}

}
