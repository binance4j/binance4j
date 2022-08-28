package com.binance4j.spot;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exception.InvalidDateException;
import com.binance4j.core.exception.NotFoundException;

public class GetKlinesTest extends SpotTest {
	@Test
	void testInvalidDate() {
		Exception exception = assertThrows(ApiException.class,
				() -> client.getKlines(symbol, interval, year, month, "32").getData());
		assertTrue(exception.getMessage().contains(new InvalidDateException().getMessage()));
	}

	@Test
	void testNotFoundSync() {
		Exception exception = assertThrows(ApiException.class,
				() -> client.getKlines(symbol, interval, "1995", month, day).getData());
		assertTrue(exception.getMessage().contains(new NotFoundException().getMessage()));
	}

	@Test
	void testGetKlines() throws ApiException {
		testNoNulls(client.getKlines(symbol, interval, year, month, day).getData());
	}
}
