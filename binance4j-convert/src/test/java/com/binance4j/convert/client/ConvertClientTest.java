package com.binance4j.convert.client;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.core.test.CustomTest;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class ConvertClientTest extends CustomTest {
	protected int page = 1;
	protected ConvertClient client = new ConvertClient(key, secret);

	public ConvertClientTest() {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetConversions() throws ApiException {
		var req = client.getConversions(
				new TimeFrame(System.currentTimeMillis() - Duration.ofDays(29).toMillis(), System.currentTimeMillis()));
		testNoNulls(req);
	}
}
