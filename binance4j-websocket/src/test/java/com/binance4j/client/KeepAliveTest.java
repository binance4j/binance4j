package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.binance4j.service.TestService;
import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.callback.WebsocketCloseObject;
import com.binance4j.websocket.trade.AggTradePayload;
import com.binance4j.websocket.trade.WebsocketAggTradeClient;

import okhttp3.Response;

public class KeepAliveTest {
	int i = 0;

	WebsocketAggTradeClient client;
	CompletableFuture<Void> future;

	@BeforeEach
	void beforeEach() {
		future = new CompletableFuture<>();
	}

	@Test
	public void test() throws InterruptedException, ExecutionException {
		client = new WebsocketAggTradeClient(TestService.SYMBOLS, new WebsocketCallback<AggTradePayload>() {

			@Override
			public void onOpen(Response response) {
				System.out.println("open");
			}

			@Override
			public void onClosing(WebsocketCloseObject websocketCloseObject) {
				System.out.println("closing");
			}

			@Override
			public void onClosed(WebsocketCloseObject websocketCloseObject) {
				System.out.println("closed");
				if (i == 5) {
					future.complete(null);
				}
				i++;
			}

			@Override
			public void onMessage(AggTradePayload message) {
				System.out.println("messsage");
				client.close(false);
			}
		});

		client.getConfiguration().setCloseAfter(Duration.ofSeconds(5));
		client.open();
		assertNull(future.get());
	}
}
