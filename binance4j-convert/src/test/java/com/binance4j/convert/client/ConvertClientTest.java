package com.binance4j.convert.client;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import com.binance4j.convert.param.ConversionParams;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;

public class ConvertClientTest extends CustomTest {
	protected int page = 1;
	protected ConvertClient client = new ConvertClient(key, secret);

	@Test
	void testGetConversions() throws ApiException {
		var req = client.getConversions(new ConversionParams(System.currentTimeMillis() - Duration.ofDays(29).toMillis(), System.currentTimeMillis()));
		testNoNulls(req);
	}
}
