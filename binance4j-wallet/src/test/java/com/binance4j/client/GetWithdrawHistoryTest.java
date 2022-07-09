package com.binance4j.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.withdraw.WithdrawHistoryRequest;
import com.binance4j.wallet.withdraw.WithdrawStatus;

class GetWithdrawHistoryTest extends WalletTest {
	// @Test
	// TODO correct test
	@DisplayName("It should return the WithdrawHistory")
	void testGetWithdrawHistory() throws ApiException {
		test(client.getWithdrawHistory().execute());
	}

	@Test
	@DisplayName("It should return the WithdrawHistory of the given asset")
	void testGetWithdrawHistoryWithAsset() throws ApiException {
		test(client.getWithdrawHistory(new WithdrawHistoryRequest(getAsset())).execute());
	}

	@Test
	@DisplayName("It should return the WithdrawHistory of the given asset and status")
	void testGetWithdrawHistoryWithAssetAndStatus() throws ApiException {
		test(new WithdrawHistoryRequest(getAsset(), WithdrawStatus.COMPLETED));
	}
}
