package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
		assertNotNull(status.getData().isLocked());
		assertNotNull(status.getData().getPlannedRecoverTime());
		assertNotNull(status.getData().getTriggerCondition().getGCR());
		assertNotNull(status.getData().getTriggerCondition().getIFER());
		assertNotNull(status.getData().getTriggerCondition().getUFR());
		assertNotNull(status.getData().getUpdateTime());
	}
}
