package com.binance4j.nft;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.nft.asset.NFTAssetHistory;
import com.binance4j.nft.asset.NFTAssetRequest;

/**
 * Tests the Deposit history request
 */
public class GetAssetsTest extends NFTTest {
	@Test
	@DisplayName("It should return a non null result")
	void testRequest() throws ApiException {
		NFTAssetRequest req = new NFTAssetRequest();
		NFTAssetHistory history = client.getAssets(req).execute();
		test(history);
	}

	@Test
	@DisplayName("It should return a non null result")
	void testLimitAndPage() throws ApiException {
		NFTAssetRequest req = new NFTAssetRequest(limit, page);
		NFTAssetHistory history = client.getAssets(req).execute();
		test(history);
		assertTrue(history.getTotal() <= limit);
	}

}
