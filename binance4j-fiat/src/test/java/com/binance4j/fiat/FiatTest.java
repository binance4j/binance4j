package com.binance4j.fiat;

import com.binance4j.core.test.CustomTest;
import com.binance4j.fiat.client.FiatClient;

public class FiatTest extends CustomTest<FiatClient> {
	public FiatTest() {
		super(FiatClient.class);
	}
}
