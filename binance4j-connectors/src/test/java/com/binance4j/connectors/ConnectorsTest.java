package com.binance4j.connectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;

public class ConnectorsTest extends CustomTest {
	Connectors connectors;

	public ConnectorsTest() {
		connectors = new Connectors(key, secret);
	}

	@Test
	void testGetBLVTClient() throws ApiException {
		assertNotNull(connectors.blvt());
	}

	@Test
	void testGetC2CClient() {
		assertNotNull(connectors.c2c());
	}

	@Test
	void testGetFiatClient() {
		assertNotNull(connectors.fiat());
	}

	@Test
	void testGetLoanClient() {
		assertNotNull(connectors.loan());
	}

	@Test
	void testGetMarginClient() {
		assertNotNull(connectors.margin());
	}

	@Test
	void testGetMarketClient() {
		assertNotNull(connectors.market());
	}

	@Test
	void testGetMiningClient() {
		assertNotNull(connectors.mining());
	}

	@Test
	void testGetNFTClient() {
		assertNotNull(connectors.nft());
	}

	@Test
	void testGetPayClient() {
		assertNotNull(connectors.pay());
	}

	@Test
	void testGetPortfolioMarginClient() {
		assertNotNull(connectors.margin());
	}

	@Test
	void testGetRebateClient() {
		assertNotNull(connectors.rebate());
	}

	@Test
	void testGetSavingsClient() {
		assertNotNull(connectors.savings());
	}

	@Test
	void testGetSpotClient() {
		assertNotNull(connectors.spot());
	}

	@Test
	void testGetStakingClient() {
		assertNotNull(connectors.staking());
	}

	@Test
	void testGetVisionSpotClient() {
		assertNotNull(connectors.visionSpot());
	}

	@Test
	void testGetWalletClient() {
		assertNotNull(connectors.wallet());
	}

	@Test
	void testUpdateKeys() {
		assertEquals(connectors.getKey(), connectors.blvt().getKey());
		assertEquals(connectors.getSecret(), connectors.blvt().getSecret());
		connectors.updateKeys("foo", "bar");
		assertEquals(connectors.getKey(), connectors.blvt().getKey());
		assertEquals(connectors.getSecret(), connectors.blvt().getSecret());
	}
}
