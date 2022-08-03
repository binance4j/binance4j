package com.binance4j.rebate.client;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.test.CustomTest;

public class RebateClientTest extends CustomTest {
	RebateClient client = new RebateClient(key, secret);

	@Test
	void testGetSpotRebateHistoryRecords() throws ApiException {
		testHasNulls(client.getSpotRebateHistoryRecords(), List.of("data"), true);
	}

	@Test
	void testGetSpotRebateHistoryRecords2() throws ApiException {
		testHasNulls(client.getSpotRebateHistoryRecords(new FramedPaging(1)), List.of("data"), true);
	}
}
