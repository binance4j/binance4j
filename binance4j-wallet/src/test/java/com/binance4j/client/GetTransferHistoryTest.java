package com.binance4j.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.dto.WalletTransferType;
import com.binance4j.wallet.param.WalletTransferHistoryParams;

class GetTransferHistoryTest extends WalletTest {

	String asset = "BTC";

	// @Test
	void testGetTransferHistoryWithTransferType() throws ApiException {
		testNoNulls(client.getTransferHistory(new WalletTransferHistoryParams(WalletTransferType.MAIN_MARGIN)));
	}

	// @Test
	void testGetTransferHistoryWithFromAndToSymbols() throws ApiException {
		testNoNulls(client.getTransferHistory(new WalletTransferHistoryParams(WalletTransferType.MAIN_MARGIN, asset, asset)));
	}

	// @Test
	void testGetTransferHistoryWithFromAndToSymbolsAndLimit() throws ApiException {
		testNoNulls(client.getTransferHistory(new WalletTransferHistoryParams(WalletTransferType.MAIN_MARGIN, asset, asset, limit)));
	}

	// @Test
	void testGetTransferHistoryWithFromAndToSymbolsAndLimitAndOffset() throws ApiException {
		testNoNulls(client.getTransferHistory(new WalletTransferHistoryParams(WalletTransferType.MAIN_MARGIN, asset, asset, limit, 1)));
	}
}
