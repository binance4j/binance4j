package com.binance4j.spot;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exception.InvalidDateException;
import com.binance4j.core.exception.NotFoundException;

public class GetAggTradesTest extends SpotTest {
	@Test
	void testInvalidDate() {
		Exception exception = assertThrows(ApiException.class,
				() -> client.getAggTrades(symbol, year, month, "32").getData());
		assertTrue(exception.getMessage().contains(new InvalidDateException().getMessage()));
	}

	@Test
	void testNotFoundSync() {
		Exception exception = assertThrows(ApiException.class,
				() -> client.getAggTrades(symbol, "1995", month, day).getData());
		assertTrue(exception.getMessage().contains(new NotFoundException().getMessage()));
	}

	@Test
	void testgetAggTrades() throws ApiException {
		testNoNulls(client.getAggTrades(symbol, year, month, day).getData());
	}
}
