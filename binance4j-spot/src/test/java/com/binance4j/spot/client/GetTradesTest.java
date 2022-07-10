package com.binance4j.spot.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.spot.order.MyTradesRequest;

public class GetTradesTest extends SpotTest {

	@Test
	@DisplayName("Properties shouldn't be null or ApiException should not be null")
	public void testGetMyTrades() throws ApiException {
		test(client.getMyTrades(new MyTradesRequest("APEBUSD")));
	}
}