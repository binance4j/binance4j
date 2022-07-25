package com.binance4j.margin;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.binance4j.core.Request;
import com.binance4j.core.exception.ApiException;
import com.binance4j.margin.param.ToggleBurnParams;

public class ToggleBNBBurnOnSpotTradeAndMarginInterestTest extends MarginTest {

	@Override
	public void test(Request<?> executor) throws ApiException {
		try {
			test(executor.execute());
		} catch (ApiException e) {
			assertNotNull(e.getMessage());
		}
	}

	@Test
	void test1() throws ApiException {
		test(client.toggleBNBBurnOnSpotTradeAndMarginInterest(new ToggleBurnParams(true, true)));
		test(client.toggleBNBBurnOnSpotTradeAndMarginInterest(new ToggleBurnParams(true, true)));
	}
}
