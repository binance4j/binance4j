package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.callback.WebsocketCloseObject;
import com.binance4j.websocket.candle.CandlePayload;
import com.binance4j.websocket.candle.WebsocketCandlestickClient;
import com.binance4j.websocket.client.WebsocketClient;

import okhttp3.Response;

class NoResponseTimeOutTest {
	static long startTime;
	static long endTime;

	@Test
	void test() throws InterruptedException, ExecutionException {

		CompletableFuture<Void> future = new CompletableFuture<>();

		WebsocketCallback<CandlePayload> callback = new WebsocketCallback<CandlePayload>() {
			@Override
			public void onMessage(CandlePayload message) {
				startTime = System.currentTimeMillis();
				System.out.println(message);
			}

			@Override
			public void onOpen(Response response) {
				System.out.println(response);
			}

			@Override
			public void onClosing(WebsocketCloseObject websocketCloseObject) {
				endTime = System.currentTimeMillis();
				double time = (endTime - startTime) / 1000;
				System.out.println(time);
				System.out.println(endTime);

				future.complete(null);
			}

			@Override
			public void onClosed(WebsocketCloseObject websocketCloseObject) {

			}

			@Override
			public void onFailure(ApiException exception) {
				System.out.println(exception);
			}

		};

		WebsocketClient client = new WebsocketCandlestickClient(getSymbol(),
				CandlestickInterval.ONE_MINUTE, callback);

		client.getConfiguration().setNoResponseTimeout(Duration.ofSeconds(2));

		client.open();

		assertNull(future.get());
	}
}
