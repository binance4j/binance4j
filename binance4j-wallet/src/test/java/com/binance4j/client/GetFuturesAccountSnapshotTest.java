package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.service.TestService;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.snapshot.AccountSnapshotRequest;
import com.binance4j.wallet.snapshot.futures.FuturesAccountSnapshotResponse;

class GetFuturesAccountSnapshotTest {
	final WalletClient client = TestService.CLIENT;

	@Test
	@DisplayName("It should return the snapshot or throw an exception if you don't have a margin account")
	void testGetFuturesAccountSnapshot() {
		try {
			FuturesAccountSnapshotResponse snapshot = client.getFuturesAccountSnapshot().execute();
			assertNotEquals(0, snapshot.getCode());

			snapshot.getSnapshotVos().forEach(s -> {
				assertNotNull(s.getType());
				assertNotNull(s.getUpdateTime());
				assertNotNull(s.getData().getPosition());
				s.getData().getAssets().forEach(a -> {
					assertNotNull(a.getAsset());
					assertNotNull(a.getMarginBalance());
					assertNotNull(a.getWalletBalance());
				});
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
				assertNotNull(s.getType());
				assertNotNull(s.getUpdateTime());
				assertNotNull(s.getData().getPosition());
				s.getData().getAssets().forEach(a -> {
					assertNotNull(a.getAsset());
					assertNotNull(a.getMarginBalance());
					assertNotNull(a.getWalletBalance());
				});
			});
		} catch (ApiException e) {

			assertTrue(true);
		}
	}
}
