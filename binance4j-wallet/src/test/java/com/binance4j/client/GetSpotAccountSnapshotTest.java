package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;

class GetSpotAccountSnapshotTest extends WalletTest {

	@Test
	void testGetSpotAccountSnapshot() throws ApiException {
		testNoNulls(client.getSpotAccountSnapshot());
	}

	@Test
	void testGetSpotAccountSnapshotWithLimit() throws ApiException {
		testNoNulls(client.getSpotAccountSnapshot(new TimeFrame(limit)));
	}
}