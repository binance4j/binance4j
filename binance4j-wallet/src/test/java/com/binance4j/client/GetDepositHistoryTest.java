package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.dto.DepositStatus;
import com.binance4j.wallet.param.DepositHistoryParams;

class GetDepositHistoryTest extends WalletTest {

	@Test
	void testGetDepositHistory() throws ApiException {
		testNoNulls(client.getDepositHistory());
	}

	@Test
	void testGetDepositHistoryOfGivenCoin() throws ApiException {
		testNoNulls(client.getDepositHistory(new DepositHistoryParams(asset)));
	}

	@Test
	void testGetDepositHistoryOfGivenStatus() throws ApiException {
		testNoNulls(client.getDepositHistory(new DepositHistoryParams(DepositStatus.SUCCESS)));
	}

	@Test
	void testGetDepositHistoryOfGivenAssetAndStatus() throws ApiException {
		testNoNulls(client.getDepositHistory(new DepositHistoryParams(asset, DepositStatus.SUCCESS)));
	}
}
