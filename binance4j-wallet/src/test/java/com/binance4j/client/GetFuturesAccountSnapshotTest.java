package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.param.AccountSnapshotParams;
import com.binance4j.wallet.param.FuturesAccountSnapshotResponse;

class GetFuturesAccountSnapshotTest extends WalletTest {

	@Test
	void testGetFuturesAccountSnapshot() throws ApiException {
		FuturesAccountSnapshotResponse snapshot = client.getFuturesAccountSnapshot().execute();
		test(snapshot);
		assertNotEquals(0, snapshot.getCode());
	}

	@Test
	void testGetFuturesAccountSnapshotWithLimit() throws ApiException {
		FuturesAccountSnapshotResponse snapshot = client.getFuturesAccountSnapshot(new AccountSnapshotParams(limit))
				.execute();
		test(snapshot);
		assertTrue(snapshot.getSnapshotVos().size() <= limit);
		assertNotEquals(0, snapshot.getCode());
	}
}
