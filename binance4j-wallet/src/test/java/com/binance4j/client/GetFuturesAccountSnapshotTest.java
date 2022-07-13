package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.snapshot.AccountSnapshotParams;
import com.binance4j.wallet.snapshot.futures.FuturesAccountSnapshotResponse;

class GetFuturesAccountSnapshotTest extends WalletTest {

	@Test
	@DisplayName("It should return the snapshot or throw an exception if you don't have a margin account")
	void testGetFuturesAccountSnapshot() throws ApiException {
		FuturesAccountSnapshotResponse snapshot = client.getFuturesAccountSnapshot().execute();
		test(snapshot);
		assertNotEquals(0, snapshot.getCode());
	}

	@Test
	@DisplayName("It should return the FuturesAccountSnapshotResponse with the good size or throw an exception if you don't have a margin account")
	void testGetFuturesAccountSnapshotWithLimit() throws ApiException {
		FuturesAccountSnapshotResponse snapshot = client.getFuturesAccountSnapshot(new AccountSnapshotParams(limit))
				.execute();
		test(snapshot);
		assertTrue(snapshot.getSnapshotVos().size() <= limit);
		assertNotEquals(0, snapshot.getCode());
	}
}
