package com.binance4j.mining.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
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

	public MiningClientTest() {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
	}

	// TODO @Test
	void testCancelHashrateResaleConfiguration() throws ApiException {
		testNoNulls(client.cancelHashrateResaleConfiguration(new HashrateResaleCancellationParams(configId, userName)));
	}

	// TODO @Test
	void testGetAccountProfits() throws ApiException {
		testNoNulls(client.getAccountProfits(new AccountProfitsParams(algo, userName)));
	}

	// TODO @Test
	void testGetAccountProfitsFramed() throws ApiException {
		testNoNulls(client.getAccountProfits(new AccountProfitsParams(algo, userName), framedPaging));
	}

	// TODO @Test
	void testGetAccounts() throws ApiException {
		testNoNulls(client.getAccounts(new AccountListParams(algo, userName)));
	}

	@Test
	void testGetAlgorithms() throws ApiException {
		testNoNulls(client.getAlgorithms());
	}

	@Test
	void testGetCoins() throws ApiException {
		testNoNulls(client.getCoins());
	}

	// TODO @Test
	void testGetHashrateResales() throws ApiException {
		testNoNulls(client.getHashrateResales());
	}

	// TODO @Test
	void testGetHashrateResales2() throws ApiException {
		testNoNulls(client.getHashrateResales(timeFrame));
	}

	// TODO @Test
	void testGetHashrateResalesDetails() throws ApiException {
		testNoNulls(client.getHashrateResalesDetails(new HashrateResaleDetailParam(configId, userName)));
	}

	// TODO @Test
	void testGetHashrateResalesDetails2() throws ApiException {
		testNoNulls(client.getHashrateResalesDetails(new HashrateResaleDetailParam(configId, userName), timeFrame));
	}

	// TODO @Test
	void testGetMiners() throws ApiException {
		testNoNulls(client.getMiners(new MinersParams(algo, userName)));
	}

	// TODO @Test
	void testGetMinersDetails() throws ApiException {
		testNoNulls(client.getMinersDetails(new MinerDetailsParams(algo, userName, workerName)));
	}

	// TODO @Test
	void testGetOtherProfits() throws ApiException {
		testNoNulls(client.getOtherProfits(new ProfitsParams(algo, userName), framedPaging));
	}

	// TODO @Test
	void testGetProfits() throws ApiException {
		testNoNulls(client.getProfits(new ProfitsParams(algo, userName), framedPaging));
	}

	@Test
	void testGetStatistics() throws ApiException {
		testNoNulls(client.getStatistics(new StatisticsParams(algo, userName)));
	}

	// TODO @Test
	void testResellHashrate() throws ApiException {
		testNoNulls(client.resellHashrate(new HashrateResaleParams(userName, algo, endDate, startDate, toPoolUser, hashRate)));
	}
}
