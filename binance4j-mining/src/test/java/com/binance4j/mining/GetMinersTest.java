package com.binance4j.mining;

import com.binance4j.core.exception.ApiException;
import com.binance4j.mining.param.MinersParams;

class GetMinersTest extends MiningTest { // @Test TODO
	void test1() throws ApiException {
		testNoNulls(client.getMiners(new MinersParams("sha256", "username")));
	}
}
