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
		assertNotNull(connectors.blvtClient());
	}

	@Test
	void testGetC2CClient() {
		assertNotNull(connectors.c2cClient());
	}

	@Test
	void testGetFiatClient() {
		assertNotNull(connectors.fiatClient());
	}

	@Test
	void testGetLoanClient() {
		assertNotNull(connectors.loanClient());
	}

	@Test
	void testGetMarginClient() {
		assertNotNull(connectors.marginClient());
	}

	@Test
	void testGetMarketClient() {
		assertNotNull(connectors.marketClient().getBookTicker());
	}

	@Test
	void testGetMiningClient() {
		assertNotNull(connectors.miningClient());
	}

	@Test
	void testGetNFTClient() {
		assertNotNull(connectors.nftClient());
	}

	@Test
	void testGetPayClient() {
		assertNotNull(connectors.payClient());
	}

	@Test
	void testGetPortfolioMarginClient() {
		assertNotNull(connectors.marginClient());
	}

	@Test
	void testGetRebateClient() {
		assertNotNull(connectors.rebateClient());
	}

	@Test
	void testGetSavingsClient() {
		assertNotNull(connectors.savingsClient());
	}

	@Test
	void testGetSpotClient() {
		assertNotNull(connectors.spotClient());
	}

	@Test
	void testGetStakingClient() {
		assertNotNull(connectors.stakingClient());
	}

	@Test
	void testGetVisionSpotClient() {
		assertNotNull(connectors.visionSpotClient());
	}

	@Test
	void testGetWalletClient() {
		assertNotNull(connectors.walletClient());
	}

	@Test
	void testUpdateKeys() {
		assertEquals(connectors.getKey(), connectors.blvtClient().getKey());
		assertEquals(connectors.getSecret(), connectors.blvtClient().getSecret());
		connectors.updateKeys("foo", "bar");
		assertEquals(connectors.getKey(), connectors.blvtClient().getKey());
		assertEquals(connectors.getSecret(), connectors.blvtClient().getSecret());
	}
}
