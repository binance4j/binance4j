package com.binance4j.client;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.dto.WithdrawStatus;
import com.binance4j.wallet.param.WithdrawHistoryParams;

class GetWithdrawHistoryTest extends WalletTest {
	@Test
	void testGetWithdrawHistory() throws ApiException {
		testHasNulls(client.getWithdrawHistory(), List.of("withdrawOrderId"), true);
	}

	@Test
	void testGetWithdrawHistoryWithAsset() throws ApiException {
		testHasNulls(client.getWithdrawHistory(new WithdrawHistoryParams(asset)), List.of("withdrawOrderId"), true);
	}

	@Test
	void testGetWithdrawHistoryWithAssetAndStatus() throws ApiException {
		WithdrawStatus status = WithdrawStatus.COMPLETED;
		testHasNulls(client.getWithdrawHistory(new WithdrawHistoryParams(asset, status)), List.of("withdrawOrderId"), true);
	}
}
