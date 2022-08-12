package com.binance4j.connectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;

public class RestConnectorsTest extends CustomTest {
	Connectors connectors;

	public RestConnectorsTest() {
		connectors = new Connectors(key, secret);
	}

	@Test
	void testGetBLVTClient() throws ApiException {
		assertNotNull(connectors.rest().blvt());
	}

	@Test
	void testGetC2CClient() {
		assertNotNull(connectors.rest().c2c());
	}

	@Test
	void testGetFiatClient() {
		assertNotNull(connectors.rest().fiat());
	}

	@Test
	void testGetLoanClient() {
		assertNotNull(connectors.rest().loan());
	}

	@Test
	void testGetMarginClient() {
		assertNotNull(connectors.rest().margin());
	}

	@Test
	void testGetMarketClient() {
		assertNotNull(connectors.rest().market());
	}

	@Test
	void testGetMiningClient() {
		assertNotNull(connectors.rest().mining());
	}

	@Test
	void testGetNFTClient() {
		assertNotNull(connectors.rest().nft());
	}

	@Test
	void testGetPayClient() {
		assertNotNull(connectors.rest().pay());
	}

	@Test
	void testGetPortfolioMarginClient() {
		assertNotNull(connectors.rest().margin());
	}

	@Test
	void testGetRebateClient() {
		assertNotNull(connectors.rest().rebate());
	}

	@Test
	void testGetSavingsClient() {
		assertNotNull(connectors.rest().savings());
	}

	@Test
	void testGetSpotClient() {
		assertNotNull(connectors.rest().spot());
	}

	@Test
	void testGetStakingClient() {
		assertNotNull(connectors.rest().staking());
	}

	@Test
	void testGetVisionSpotClient() {
		assertNotNull(connectors.rest().visionSpot());
	}

	@Test
	void testGetWalletClient() {
		assertNotNull(connectors.rest().wallet());
	}

	@Test
	void testUpdateKeys() {
		assertEquals(connectors.rest().getKey(), connectors.rest().blvt().getKey());
		assertEquals(connectors.rest().getSecret(), connectors.rest().blvt().getSecret());
		connectors.rest().updateKeys("foo", "bar");
		assertEquals(connectors.rest().getKey(), connectors.rest().blvt().getKey());
		assertEquals(connectors.rest().getSecret(), connectors.rest().blvt().getSecret());
	}

	@Override
	protected RestClient<?> getClient() {
		// TODO Auto-generated method stub
		return null;
	}
}
