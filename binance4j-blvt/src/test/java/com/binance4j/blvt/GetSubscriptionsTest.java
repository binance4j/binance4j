package com.binance4j.blvt;

import org.junit.jupiter.api.Test;
import com.binance4j.core.exception.ApiException;

public class GetSubscriptionsTest extends BLVTTest {
	@Test
	public void test1() throws ApiException {
		testNoNulls(client.getSubscriptions());
	}
}