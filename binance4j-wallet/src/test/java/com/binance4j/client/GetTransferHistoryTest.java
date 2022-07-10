package com.binance4j.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.transfer.WalletTransferHistory;
import com.binance4j.wallet.transfer.WalletTransferHistoryRequest;
import com.binance4j.wallet.transfer.WalletTransferType;

class GetTransferHistoryTest extends WalletTest {

	String asset = "BTC";

	@Test
	@DisplayName("It should return the transfer history")
	void testGetTransferHistoryWithTransferType() throws ApiException {
		test(client.getTransferHistory(new WalletTransferHistoryRequest(WalletTransferType.MAIN_MARGIN)).execute());
	}

	@Test
	@DisplayName("It should return the transfer history with the given symbol")
	void testGetTransferHistoryWithFromAndToSymbols() throws ApiException {
		test(client.getTransferHistory(new WalletTransferHistoryRequest(WalletTransferType.MAIN_MARGIN, asset, asset))
				.execute());
	}

	@Test
	@DisplayName("It should return the transfer history with the given symbol")
	void testGetTransferHistoryWithFromAndToSymbolsAndLimit() throws ApiException {
		WalletTransferHistory history = client
				.getTransferHistory(
						new WalletTransferHistoryRequest(WalletTransferType.MAIN_MARGIN, asset, asset, limit))
				.execute();
		test(history);
	}

	@Test
	@DisplayName("It should return the transfer history with the given symbol")
	void testGetTransferHistoryWithFromAndToSymbolsAndLimitAndOffset() throws ApiException {
		test(client
				.getTransferHistory(
						new WalletTransferHistoryRequest(WalletTransferType.MAIN_MARGIN, asset, asset, limit, 1))
				.execute());
	}
}
