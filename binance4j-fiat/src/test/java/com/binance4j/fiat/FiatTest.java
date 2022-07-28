package com.binance4j.fiat;

import java.time.Duration;

import com.binance4j.core.test.CustomTest;
import com.binance4j.fiat.client.FiatClient;

public class FiatTest extends CustomTest<FiatClient> {
	protected Long oneYearAgo = System.currentTimeMillis() - Duration.ofDays(365).toMillis();

	public FiatTest() {
		super(FiatClient.class);
	}
}
