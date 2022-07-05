package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.service.TestService;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.tradingstatus.ApiTradingStatus;

public class GetApiTradingStatusTest {
	final WalletClient client = TestService.CLIENT;

	@Test
	@DisplayName("It should return the api trading status")
	void testGetApiTradingStatusOfAll() throws ApiException {
		ApiTradingStatus status = client.getApiTradingStatus().execute();
		assertTrue(TestService.hasNoNullProperty(status.getData()));
		assertTrue(TestService.hasNoNullProperty(status.getData().getTriggerCondition()));
	}
}
