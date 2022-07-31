package com.binance4j.pay;

import org.junit.jupiter.api.Test;
import com.binance4j.core.exception.ApiException;

public class GetTradesTest extends PayTest {
	@Test
	void test1() throws ApiException {
		testNoNulls(client.getTrades());
	}
}
