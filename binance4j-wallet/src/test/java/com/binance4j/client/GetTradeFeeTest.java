package com.binance4j.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.tradefee.TradeFeeParams;

class GetTradeFeeTest extends WalletTest {

	@Test
	@DisplayName("It should return the trade fee of all assets")
	void testGetTradeFeeOfAll() throws ApiException {
		test(client.getTradeFee());
	}

	@Test
	@DisplayName("It should return the trade fee of one asset")
	void testGetTradeFeeOfOne() throws ApiException {
		test(client.getTradeFee(new TradeFeeParams("BNBBTC")));
	}
}
