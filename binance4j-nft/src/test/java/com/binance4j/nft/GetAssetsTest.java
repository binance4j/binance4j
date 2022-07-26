package com.binance4j.nft;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.nft.dto.AssetHistory;
import com.binance4j.nft.param.AssetParams;

/** Tests the Deposit history request */
public class GetAssetsTest extends NFTTest {
	@Test
	void testRequest() throws ApiException {
		testNoNulls(client.getAssets());
	}

	@Test
	void testLimitAndPage() throws ApiException {
		AssetHistory history = client.getAssets(new AssetParams(limit, page)).execute();
		testNoNulls(history);
		assertTrue(history.total() <= limit);
	}

}
