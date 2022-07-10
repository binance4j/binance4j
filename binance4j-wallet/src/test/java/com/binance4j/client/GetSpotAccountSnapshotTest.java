package com.binance4j.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.snapshot.AccountSnapshotRequest;

class GetSpotAccountSnapshotTest extends WalletTest {

	@Test
	@DisplayName("It should return the snapshot")
	void testGetSpotAccountSnapshot() throws ApiException {
		test(client.getSpotAccountSnapshot());
	}

	@Test
	@DisplayName("It should return the snapshot with the good size or throw an exception if you don't have a margin account")
	void testGetSpotAccountSnapshotWithLimit() throws ApiException {
		test(client.getSpotAccountSnapshot(new AccountSnapshotRequest(limit)));
	}
}