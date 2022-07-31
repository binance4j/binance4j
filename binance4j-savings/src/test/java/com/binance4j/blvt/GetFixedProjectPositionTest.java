package com.binance4j.blvt;

import com.binance4j.core.exception.ApiException;
import com.binance4j.savings.param.FixedProjectPositionParams;

public class GetFixedProjectPositionTest extends SavingsTest { // TODO @Test
	void test1() throws ApiException {
		testNoNulls(client.getFixedProjectPosition(new FixedProjectPositionParams()));
	}
}
