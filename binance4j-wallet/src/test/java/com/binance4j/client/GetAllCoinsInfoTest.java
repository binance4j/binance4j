package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;

class GetAllCoinsInfoTest extends WalletTest {

	@Override
	public void test(Object bean) {
		List<String> expectedNulls = List.of("specialTips", "specialWithdrawTips", "depositDust");
		Set<String> nulls = getNullProperties(bean, true);
		assertTrue(nulls.containsAll(nulls));
		assertEquals(nulls.size(), expectedNulls.size());
	}

	@Test
	void testGetAllCoinsInfo() throws ApiException {
		test(client.getAllCoinsInfo());
	}
}
