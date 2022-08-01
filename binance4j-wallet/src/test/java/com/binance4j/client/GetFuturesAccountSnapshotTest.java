package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.wallet.dto.FuturesAccountSnapshotResponse;

class GetFuturesAccountSnapshotTest extends WalletTest {
	@Test
	void testGetFuturesAccountSnapshot() throws ApiException {
		FuturesAccountSnapshotResponse snapshot = client.getFuturesAccountSnapshot().fetch();
		testNoNulls(snapshot);
		assertNotEquals(0, snapshot.code());
	}

	@Test
	void testGetFuturesAccountSnapshotWithLimit() throws ApiException {
		FuturesAccountSnapshotResponse snapshot = client.getFuturesAccountSnapshot(new TimeFrame(limit)).fetch();
		testNoNulls(snapshot);
		assertTrue(snapshot.snapshotVos().size() <= limit);
		assertNotEquals(0, snapshot.code());
	}
}
