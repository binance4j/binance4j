package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.transfer.WalletTransferHistory;
import com.binance4j.wallet.transfer.WalletTransferHistoryParams;
import com.binance4j.wallet.transfer.WalletTransferType;

class GetTransferHistoryTest extends WalletTest {

	String asset = "BTC";

	@Test

	void testGetTransferHistoryWithTransferType() throws ApiException {
		test(client.getTransferHistory(new WalletTransferHistoryParams(WalletTransferType.MAIN_MARGIN)));
	}

	@Test

	void testGetTransferHistoryWithFromAndToSymbols() throws ApiException {
		test(client.getTransferHistory(new WalletTransferHistoryParams(WalletTransferType.MAIN_MARGIN, asset, asset))
				.execute());
	}

	@Test

	void testGetTransferHistoryWithFromAndToSymbolsAndLimit() throws ApiException {
		WalletTransferHistory history = client
				.getTransferHistory(
						new WalletTransferHistoryParams(WalletTransferType.MAIN_MARGIN, asset, asset, limit))
				.execute();
		test(history);
	}

	@Test

	void testGetTransferHistoryWithFromAndToSymbolsAndLimitAndOffset() throws ApiException {
		test(client
				.getTransferHistory(
						new WalletTransferHistoryParams(WalletTransferType.MAIN_MARGIN, asset, asset, limit, 1))
				.execute());
	}
}
