package com.binance4j.nft;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.nft.dto.AssetHistory;

/** Tests the Deposit history request */
public class GetAssetsTest extends NFTTest {
	@Test
	void testRequest() throws ApiException {
		testNoNulls(client.getAssets());
	}

	@Test
	void testLimitAndPage() throws ApiException {
		AssetHistory history = client.getAssets().fetch();
		testNoNulls(history);
		assertTrue(history.total() <= limit);
	}
}
