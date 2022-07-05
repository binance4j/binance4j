package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.service.TestService;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.tradefee.TradeFee;
import com.binance4j.wallet.tradefee.TradeFeeRequest;

class GetTradeFeeTest {
	final WalletClient client = TestService.CLIENT;

	@Test
	@DisplayName("It should return the trade fee of all assets")
	void testGetTradeFeeOfAll() throws ApiException {
		List<TradeFee> fees = client.getTradeFee().execute();
		assertTrue(TestService.hasNoNullProperty(fees));
		fees.forEach(f -> assertTrue(TestService.hasNoNullProperty(f)));
	}

	@Test
	@DisplayName("It should return the trade fee of one asset")
	void testGetTradeFeeOfOne() throws ApiException {
		List<TradeFee> fees = client.getTradeFee(new TradeFeeRequest("BNBBTC")).execute();
		assertTrue(TestService.hasNoNullProperty(fees));
		fees.forEach(f -> assertTrue(TestService.hasNoNullProperty(f)));
	}
}
