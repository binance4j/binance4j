package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dust.DustLog;
import com.binance4j.wallet.dust.DustLogRequest;

class GetDustLogTest {
	final WalletClient client = CLIENT;

	@Test
	@DisplayName("It should return the dust transfer history")
	void testGetDustLog() throws ApiException {
		DustLog log = client.getDustLog(new DustLogRequest()).execute();
		assertTrue(hasNoNullProperty(log));

		log.getUserAssetDribblets().forEach(a -> {
			assertTrue(hasNoNullProperty(a));
			a.getUserAssetDribbletDetails().forEach(d -> assertTrue(hasNoNullProperty(d)));
		});
	}

}
