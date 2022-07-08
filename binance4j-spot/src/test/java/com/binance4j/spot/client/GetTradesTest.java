package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.spot.order.MyTradesRequest;

public class GetTradesTest extends ConcurrentTest {
	final SpotClient client = SpotCLIENT;

	@Test
	@DisplayName("Properties shouldn't be null or ApiException should not be null")
	public void testGetMyTrades() throws ApiException {
		client.getMyTrades(new MyTradesRequest("APEBUSD")).execute().forEach(trade -> assertTrue(
				SpothasNoNullProperty(trade)));
	}
}