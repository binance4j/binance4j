package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.service.TestService;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.transfer.WalletTransferHistory;
import com.binance4j.wallet.transfer.WalletTransferHistoryRequest;
import com.binance4j.wallet.transfer.WalletTransferType;

class GetTransferHistoryTest {
	final WalletClient client = TestService.CLIENT;

	static void test(WalletTransferHistory history) {

		assertNotNull(history.getTotal());
		if (history.getRows() != null) {
			history.getRows().forEach(r -> {
				assertNotNull(r.getAmount());
				assertNotNull(r.getAsset());
				assertNotNull(r.getStatus());
				assertNotNull(r.getTimestamp());
				assertNotNull(r.getTranId());
				assertNotNull(r.getType());
			});
		}
	}

	@Test
	@DisplayName("It should return the transfer history")
	void testGetTransferHistoryWithTransferType() throws ApiException {
		WalletTransferHistory history = client
				.getTransferHistory(new WalletTransferHistoryRequest(WalletTransferType.MAIN_MARGIN)).execute();
		test(history);
	}

	@Test
	@DisplayName("It should return the transfer history with the given symbol")
	void testGetTransferHistoryWithFromAndToSymbols() throws ApiException {
		String asset = "BTC";
		WalletTransferHistory history = client
				.getTransferHistory(new WalletTransferHistoryRequest(WalletTransferType.MAIN_MARGIN, asset, asset))
				.execute();

		if (history.getRows() != null) {
			history.getRows().forEach(r -> assertEquals(r.getAsset(), asset));
		}

		test(history);
	}

	@Test
	@DisplayName("It should return the transfer history with the given symbol")
	void testGetTransferHistoryWithFromAndToSymbolsAndLimit() throws ApiException {
		String asset = "BTC";
		int limit = 25;
		WalletTransferHistory history = client
				.getTransferHistory(
						new WalletTransferHistoryRequest(WalletTransferType.MAIN_MARGIN, asset, asset, limit))
				.execute();

		if (history.getRows() != null) {
			assertTrue(history.getRows().size() <= limit);
			history.getRows().forEach(r -> assertEquals(r.getAsset(), asset));
		}

		test(history);
	}

	@Test
	@DisplayName("It should return the transfer history with the given symbol")
	void testGetTransferHistoryWithFromAndToSymbolsAndLimitAndOffset() throws ApiException {
		String asset = "BTC";
		int limit = 25;
		WalletTransferHistory history = client
				.getTransferHistory(
						new WalletTransferHistoryRequest(WalletTransferType.MAIN_MARGIN, asset, asset, limit, 1))
				.execute();

		if (history.getRows() != null) {
			assertTrue(history.getRows().size() <= limit);
			history.getRows().forEach(r -> assertEquals(r.getAsset(), asset));
		}

		test(history);
	}
}
