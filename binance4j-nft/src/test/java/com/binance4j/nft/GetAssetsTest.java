package com.binance4j.nft;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.nft.asset.NFTAssetHistory;
import com.binance4j.nft.asset.NFTAssetRequest;
import com.binance4j.nft.client.NFTClient;
import com.binance4j.nft.service.TestService;

/**
 * Tests the Deposit history request
 */
public class GetAssetsTest {
	final NFTClient client = TestService.CLIENT;
	final int limit = 25;
	final int page = 1;

	@Test
	@DisplayName("It should return a non null result")
	void testRequest() throws ApiException {
		NFTAssetRequest req = new NFTAssetRequest();
		test(req);
	}

	@Test
	@DisplayName("It should return a non null result")
	void testLimitAndPage() throws ApiException {
		NFTAssetRequest req = new NFTAssetRequest(limit, page);
		testLimit(req);
	}

	/**
	 * Tests that the result fields ar not null
	 *
	 * @param req The request
	 * @throws ApiException The Exception sent by the server
	 */
	NFTAssetHistory test(NFTAssetRequest req) throws ApiException {
		NFTAssetHistory history = client.getAssets(req).execute();


		assertNotNull(history.getTotal());

		history.getList().forEach(deposit -> {
			assertNotNull(deposit.getContractAddress());
			assertNotNull(deposit.getNetwork());
			assertNotNull(deposit.getTokenId());
		});
		return history;
	}

	/**
	 * Tests that the result fields ar not null and that the total is inferior or
	 * equal to the request limit
	 *
	 * @param req The request
	 * @throws ApiException The Exception sent by the server
	 */
	void testLimit(NFTAssetRequest req) throws ApiException {
		NFTAssetHistory history = test(req);
		assertTrue(history.getTotal() <= limit);
	}
}
