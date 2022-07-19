package com.binance4j.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.dto.WalletTransferHistory;
import com.binance4j.wallet.dto.WalletTransferType;
import com.binance4j.wallet.param.WalletTransferHistoryParams;

class GetTransferHistoryTest extends WalletTest {

	String asset = "BTC";

	// TODO @Test
	void testGetTransferHistoryWithTransferType() throws ApiException {
		test(client.getTransferHistory(new WalletTransferHistoryParams(WalletTransferType.MAIN_MARGIN)));
	}

	// TODO @Test
	void testGetTransferHistoryWithFromAndToSymbols() throws ApiException {
		test(client.getTransferHistory(new WalletTransferHistoryParams(WalletTransferType.MAIN_MARGIN, asset, asset)).execute());
	}

	// TODO @Test
	void testGetTransferHistoryWithFromAndToSymbolsAndLimit() throws ApiException {
		WalletTransferHistory history = client.getTransferHistory(new WalletTransferHistoryParams(WalletTransferType.MAIN_MARGIN, asset, asset, limit))
				.execute();
		test(history);
	}

	// TODO @Test
	void testGetTransferHistoryWithFromAndToSymbolsAndLimitAndOffset() throws ApiException {
		test(client.getTransferHistory(new WalletTransferHistoryParams(WalletTransferType.MAIN_MARGIN, asset, asset, limit, 1)).execute());
	}
}
