package com.binance4j.margin;

import com.binance4j.core.test.CustomTest;
import com.binance4j.margin.client.MarginClient;

public abstract class MarginTest extends CustomTest {
	protected MarginClient client = new MarginClient(key, secret);
}
