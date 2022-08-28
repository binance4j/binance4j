package com.binance4j.mining.client;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Paging;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.core.test.CustomTest;
import com.binance4j.mining.param.AccountListParams;
import com.binance4j.mining.param.AccountProfitsParams;
import com.binance4j.mining.param.HashrateResaleCancellationParams;
import com.binance4j.mining.param.HashrateResaleDetailParam;
import com.binance4j.mining.param.HashrateResaleParams;
import com.binance4j.mining.param.MinerDetailsParams;
import com.binance4j.mining.param.MinersParams;
import com.binance4j.mining.param.ProfitsParams;
import com.binance4j.mining.param.StatisticsParams;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class MiningClientTest extends CustomTest {
	String algo = "sha256";
	int configId = 123;
	String userName = "vivienld";
	String workerName = "vivienld.001";
	String toPoolUser = "toPoolUser";
	FramedPaging framedPaging = new FramedPaging(1);
	TimeFrame timeFrame = new TimeFrame(limit);
	Long endDate = System.currentTimeMillis();
	Long startDate = System.currentTimeMillis() - 365 * 24 * 60 * 60 * 1000;
	Long hashRate = 0L;
	MiningClient client = new MiningClient(key, secret);
	Paging paging = new Paging(1, limit);

	public MiningClientTest() {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetAccounts() throws ApiException {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testHasNulls(client.getAccounts(new AccountListParams(algo, userName)), List.of("list", "userName"), true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetAlgorithms() throws ApiException {
		testNotThrow(client.getAlgorithms());
	}

	@Test
	void testGetCoins() throws ApiException {
		testNotThrow(client.getCoins());
	}

	@Test
	void testGetStatistics() throws ApiException {
		testNotThrow(client.getStatistics(new StatisticsParams(algo, userName)));
	}

	// NOT TESTED SINCE I DON'T MINE

	// TODO @Test
	void testResellHashrate() throws ApiException {
		testNotThrow(client
				.resellHashrate(new HashrateResaleParams(userName, algo, endDate, startDate, toPoolUser, hashRate)));
	}

	// TODO @Test
	void testCancelHashrateResaleConfiguration() throws ApiException {
		testNotThrow(
				client
						.cancelHashrateResaleConfiguration(new HashrateResaleCancellationParams(configId, userName)));
	}

	// TODO @Test
	void testGetAccountProfits() throws ApiException {
		testNotThrow(client.getAccountProfits(new AccountProfitsParams(algo, userName)));
	}

	// TODO @Test
	void testGetAccountProfitsFramed() throws ApiException {
		testNotThrow(client.getAccountProfits(new AccountProfitsParams(algo, userName), framedPaging));
	}

	// TODO @Test
	void testGetHashrateResales() throws ApiException {
		testNotThrow(client.getHashrateResales());
	}

	// TODO @Test
	void testGetHashrateResales2() throws ApiException {
		testNotThrow(client.getHashrateResales(paging));
	}

	// TODO @Test
	void testGetHashrateResalesDetails() throws ApiException {
		testNotThrow(client.getHashrateResalesDetails(new HashrateResaleDetailParam(configId, userName)));
	}

	// TODO @Test
	void testGetHashrateResalesDetails2() throws ApiException {
		testNotThrow(client.getHashrateResalesDetails(new HashrateResaleDetailParam(configId, userName), paging));
	}

	// TODO @Test
	void testGetMiners() throws ApiException {
		testNotThrow(client.getMiners(new MinersParams(algo, userName)));
	}

	// TODO @Test
	void testGetMinersDetails() throws ApiException {
		testNotThrow(client.getMinersDetails(new MinerDetailsParams(algo, userName, workerName)));
	}

	// TODO @Test
	void testGetOtherProfits() throws ApiException {
		testNotThrow(client.getOtherProfits(new ProfitsParams(algo, userName), framedPaging));
	}

	// TODO @Test
	void testGetProfits() throws ApiException {
		testNotThrow(client.getProfits(new ProfitsParams(algo, userName), framedPaging));
	}

}
