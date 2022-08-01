package com.binance4j.blvt;

import com.binance4j.core.test.CustomTest;
import com.binance4j.savings.client.SavingsClient;

public abstract class SavingsTest extends CustomTest {
	protected SavingsClient client = new SavingsClient(key, secret);
}
