package com.binance4j.client;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.websocket.candle.CandlePayload;
import com.binance4j.websocket.candle.WebsocketCandlestickClient;

class WebsocketCandlestickClientTest {

	TestCallback<CandlePayload> callback = new TestCallback<>();

	@Test
	void test1() throws ApiException, InterruptedException, ExecutionException {
		WebsocketCandlestickClient client = new WebsocketCandlestickClient(callback.getSymbol(),
				CandlestickInterval.ONE_MINUTE,
				callback);
		callback.setWebsocketClient(client);
		client.open();
		callback.future.get();
	}
}