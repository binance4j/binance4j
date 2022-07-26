package com.binance4j.spot.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.spot.param.MyTradesParams;

public class GetTradesTest extends SpotTest {

	@Test
	public void testGetMyTrades() throws ApiException {
		testNoNulls(client.getMyTrades(new MyTradesParams("APEBUSD")));
	}
}