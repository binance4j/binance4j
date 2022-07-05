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
import com.binance4j.wallet.snapshot.spot.SpotAccountSnapshotResponse;

class GetSpotAccountSnapshotTest {
	final WalletClient client = TestService.CLIENT;

	@Test
	@DisplayName("It should return the snapshot")
	void testGetSpotAccountSnapshot() throws ApiException {
		SpotAccountSnapshotResponse snapshot = client.getSpotAccountSnapshot().execute();
		assertNotEquals(0, snapshot.getCode());
		assertNotNull(snapshot.getMsg());

		snapshot.getSnapshotVos().forEach(s -> {
			assertTrue(TestService.hasNoNullProperty(s));
			assertTrue(TestService.hasNoNullProperty(s.getData()));
			s.getData().getBalances().forEach(b -> assertTrue(TestService.hasNoNullProperty(b)));
		});
	}

	@Test
	@DisplayName("It should return the snapshot with the good size or throw an exception if you don't have a margin account")
	void testGetSpotAccountSnapshotWithLimit() throws ApiException {
			int limit = 25;
			AccountSnapshotRequest req = new AccountSnapshotRequest(limit);
			SpotAccountSnapshotResponse snapshot = client.getSpotAccountSnapshot(req).execute();
			assertNotEquals(0, snapshot.getCode());
			assertNotNull(snapshot.getMsg());

			snapshot.getSnapshotVos().forEach(s -> {
				assertTrue(TestService.hasNoNullProperty(s));
				assertTrue(TestService.hasNoNullProperty(s.getData()));
				s.getData().getBalances().forEach(b -> assertTrue(TestService.hasNoNullProperty(b)));
			});
	}
}
