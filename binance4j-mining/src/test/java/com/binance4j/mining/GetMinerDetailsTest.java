package com.binance4j.mining;

import com.binance4j.core.exception.ApiException;
import com.binance4j.mining.param.MinerDetailsParams;

class GetMinerDetailsTest extends MiningTest {

	// @Test TODO
	void test1() throws ApiException {
		testNoNulls(client.getMinersDetails(new MinerDetailsParams("algo", "userName", "workerName")));
	}
}
