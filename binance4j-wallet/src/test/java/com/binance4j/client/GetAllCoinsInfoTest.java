package com.binance4j.client;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

class GetAllCoinsInfoTest extends WalletTest {
	@Test
	void testGetAllCoinsInfo() throws ApiException {
		testHasNulls(client.getAllCoinsInfo(), List.of("specialTips", "specialWithdrawTips", "depositDust"), true);
	}
}
