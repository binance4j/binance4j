package com.binance4j.blvt;

import org.junit.jupiter.api.Test;

import com.binance4j.blvt.param.TokenInfoParams;
import com.binance4j.core.exception.ApiException;

public class GetTokenInfoTest extends BLVTTest {

	@Test
	public void test1() throws ApiException {
		test(client.getTokenInfo());
	}

	@Test
	public void test2() throws ApiException {
		test(client.getTokenInfo(new TokenInfoParams("BTCDOWN")));
	}
}