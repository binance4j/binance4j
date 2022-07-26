package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.dto.DepositHistory;
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

	@Test
	void testGetDepositHistoryOfGivenAssetAndStatusAndLimit() throws ApiException {
		testNoNulls(client.getDepositHistory(new DepositHistoryParams(asset, DepositStatus.SUCCESS, limit)));
	}

	@Test
	void testGetDepositHistoryOfGivenAssetAndStatusAndLimitAndOffset() throws ApiException {
		List<DepositHistory> history = client.getDepositHistory(new DepositHistoryParams(asset, DepositStatus.SUCCESS, limit, 0)).execute();
		testNoNulls(history);

		assertTrue(history.size() <= limit);
		history.forEach(h -> {
			assertEquals(asset, h.coin());
			assertEquals(DepositStatus.SUCCESS, h.getDepositStatus());
		});
	}
}
