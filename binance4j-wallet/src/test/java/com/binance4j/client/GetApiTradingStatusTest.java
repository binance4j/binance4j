package com.binance4j.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.service.TestService;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.tradingstatus.ApiTradingStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetApiTradingStatusTest {
	final WalletClient client = TestService.CLIENT;

	@Test
	@DisplayName("It should return the api trading status")
	void testGetApiTradingStatusOfAll() throws ApiException {
		ApiTradingStatus status = client.getApiTradingStatus().execute();
		assertNotNull(status.getData().getIsLocked());
		assertNotNull(status.getData().getPlannedRecoverTime());
		assertNotNull(status.getData().getTriggerCondition().getGCR());
		assertNotNull(status.getData().getTriggerCondition().getIFER());
		assertNotNull(status.getData().getTriggerCondition().getUFR());
		assertNotNull(status.getData().getUpdateTime());
	}
}
