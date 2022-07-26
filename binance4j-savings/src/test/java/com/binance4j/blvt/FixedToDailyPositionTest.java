package com.binance4j.blvt;

import com.binance4j.core.exception.ApiException;
import com.binance4j.savings.param.ChangePositionParams;

public class FixedToDailyPositionTest extends SavingsTest {

	// @Test TODO
	void test1() throws ApiException {
		testNoNulls(client.fixedToDailyPosition(new ChangePositionParams("projectId")));
	}
}
