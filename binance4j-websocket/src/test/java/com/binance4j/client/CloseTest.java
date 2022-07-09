package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.utils.TestCallback;
import com.binance4j.websocket.trade.AggTradePayload;
import com.binance4j.websocket.trade.WebsocketAggTradeClient;

public class CloseTest extends ConcurrentTest<WebsocketAggTradeClient> {

	protected CloseTest() {
		super();
	}

	CompletableFuture<Void> future;

	@BeforeEach
	void beforeEach() {
		future = new CompletableFuture<>();
	}

	@Test
	public void test() throws InterruptedException, ExecutionException {
		TestCallback<AggTradePayload> callback = new TestCallback<AggTradePayload>();
		client = new WebsocketAggTradeClient(getSymbols(), callback);
		callback.setClient(client);
		client.open();
		assertNull(future.get());
	}
}
