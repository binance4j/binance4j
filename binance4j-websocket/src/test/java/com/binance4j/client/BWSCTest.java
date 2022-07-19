package com.binance4j.client;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.callback.WebsocketCloseObject;
import com.binance4j.websocket.client.BWSC;

import okhttp3.Response;

public class BWSCTest {

	@Test
	void test1() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = new CompletableFuture<>();
		BWSC ws = new BWSC(null, "!bookTicker", new WebsocketCallback<String>() {
			@Override
			public void onOpen(Response response) {
				System.out.println(response);
			}

			@Override
			public void onClosing(WebsocketCloseObject websocketCloseObject) {
				System.out.println(websocketCloseObject);
			}

			@Override
			public void onClosed(WebsocketCloseObject websocketCloseObject) {
				System.out.println(websocketCloseObject);
			}

			@Override
			public void onFailure(ApiException exception) {
				System.out.println(exception);
			}

			public void onMessage(String message) {
				System.out.println(message);
			};
		});

		ws.open();
		future.get();
	}
}
