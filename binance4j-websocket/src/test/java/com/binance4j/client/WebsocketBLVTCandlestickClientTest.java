package com.binance4j.client;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.client.WebsocketBLVTCandlestickClient;
import com.binance4j.websocket.dto.BLVTCandleEvent;

public class WebsocketBLVTCandlestickClientTest {
	TestCallback<BLVTCandleEvent> callback = new TestCallback<>();

	@Test // TODO See why client is disconnected after connection
	void test1() throws ApiException, InterruptedException, ExecutionException {
		WebsocketBLVTCandlestickClient client = new WebsocketBLVTCandlestickClient("BTCBUSD", CandlestickInterval.ONE_MINUTE, callback);
		callback.setWebsocketClient(client);
		client.open();
		callback.future.get();
	}
}
