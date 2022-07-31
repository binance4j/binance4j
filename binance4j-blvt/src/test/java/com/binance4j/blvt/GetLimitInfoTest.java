package com.binance4j.blvt;

import org.junit.jupiter.api.Test;
import com.binance4j.blvt.param.LimitInfoParams;
import com.binance4j.core.exception.ApiException;

public class GetLimitInfoTest extends BLVTTest {
	@Test
	public void test1() throws ApiException {
		testNoNulls(client.getLimitInfo());
	}

	@Test
	public void test2() throws ApiException {
		testNoNulls(client.getLimitInfo(new LimitInfoParams("1INCHDOWN")));
	}
}