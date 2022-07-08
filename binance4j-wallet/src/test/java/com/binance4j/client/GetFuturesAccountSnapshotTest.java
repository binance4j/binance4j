package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.snapshot.AccountSnapshotRequest;
import com.binance4j.wallet.snapshot.futures.FuturesAccountSnapshotResponse;

class GetFuturesAccountSnapshotTest {
	final WalletClient client = CLIENT;

	@Test
	@DisplayName("It should return the snapshot or throw an exception if you don't have a margin account")
	void testGetFuturesAccountSnapshot() {
		try {
			FuturesAccountSnapshotResponse snapshot = client.getFuturesAccountSnapshot().execute();
			assertNotEquals(0, snapshot.getCode());

			snapshot.getSnapshotVos().forEach(s -> {
				assertTrue(hasNoNullProperty(s));
				s.getData().getAssets().forEach(a -> assertTrue(hasNoNullProperty(a)));
			});
		} catch (ApiException e) {
			assertTrue(true);
		}
	}

	@Test
	@DisplayName("It should return the FuturesAccountSnapshotResponse with the good size or throw an exception if you don't have a margin account")
	void testGetFuturesAccountSnapshotWithLimit() {
		try {
			int limit = 25;
			AccountSnapshotRequest req = new AccountSnapshotRequest(limit);
			FuturesAccountSnapshotResponse snapshot = client.getFuturesAccountSnapshot(req).execute();

			assertTrue(snapshot.getSnapshotVos().size() <= limit);
			assertNotEquals(0, snapshot.getCode());

			snapshot.getSnapshotVos().forEach(s -> {
				assertTrue(hasNoNullProperty(s));
				s.getData().getAssets().forEach(a -> assertTrue(hasNoNullProperty(a)));
			});
		} catch (ApiException e) {

			assertTrue(true);
		}
	}
}
