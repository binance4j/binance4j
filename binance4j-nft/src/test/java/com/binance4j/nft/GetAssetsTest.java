package com.binance4j.nft;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.nft.dto.NFTAssetHistory;
import com.binance4j.nft.param.NFTAssetParams;

/** Tests the Deposit history request */
public class GetAssetsTest extends NFTTest {
	@Test
	void testRequest() throws ApiException {
		NFTAssetParams params = new NFTAssetParams();
		NFTAssetHistory history = client.getAssets(params).execute();
		test(history);
	}

	@Test
	void testLimitAndPage() throws ApiException {
		NFTAssetParams params = new NFTAssetParams(limit, page);
		NFTAssetHistory history = client.getAssets(params).execute();
		test(history);
		assertTrue(history.total() <= limit);
	}

}
