package com.binance4j.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.dust.DustLogParams;

class GetDustLogTest extends WalletTest {

	@Test

	void testGetDustLog() throws ApiException {
		test(client.getDustLog(new DustLogParams()));
	}
}