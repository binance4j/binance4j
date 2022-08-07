package com.binance4j.rebate.client;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.test.CustomTest;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class RebateClientTest extends CustomTest {
	RebateClient client = new RebateClient(key, secret);

	public RebateClientTest() {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetSpotRebateHistoryRecords() throws ApiException {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testHasNulls(client.getSpotRebateHistoryRecords(), List.of("data"), true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetSpotRebateHistoryRecords2() throws ApiException {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testHasNulls(client.getSpotRebateHistoryRecords(new FramedPaging(1)), List.of("data"), true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}
}
