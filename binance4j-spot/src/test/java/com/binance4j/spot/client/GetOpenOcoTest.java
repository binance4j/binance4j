package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

public class GetOpenOcoTest extends SpotTest {

	@Test
	@DisplayName("Properties shouldn't be null or ApiException should not be null")
	public void testGetOpenOCO() throws ApiException {
		client.getOpenOCO().execute().forEach(oco -> assertTrue(hasNoNullProperty(oco)));
	}
}