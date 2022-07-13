package com.binance4j.spot.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.spot.order.MyTradesParams;

public class GetTradesTest extends SpotTest {

	@Test

	public void testGetMyTrades() throws ApiException {
		test(client.getMyTrades(new MyTradesParams("APEBUSD")));
	}
}