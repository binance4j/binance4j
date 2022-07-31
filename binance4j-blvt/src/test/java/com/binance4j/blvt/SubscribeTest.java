package com.binance4j.blvt;

import com.binance4j.blvt.param.SubscriptionParams;
import com.binance4j.core.exception.ApiException;

public class SubscribeTest extends BLVTTest { // @Test TODO
	public void test1() throws ApiException {
		testNoNulls(client.subscribe(new SubscriptionParams("tokenName", "cost")));
	}
}