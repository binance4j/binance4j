package com.binance4j.spot.client;

import org.junit.jupiter.api.Test;
import com.binance4j.core.exception.ApiException;

public class GetAllOcoTest extends SpotTest {
	@Test
	public void testGetAllOCO() throws ApiException {
		testNoNulls(client.getAllOCO());
	}
}
