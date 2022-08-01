package com.binance4j.pay;

import com.binance4j.core.test.CustomTest;
import com.binance4j.pay.client.PayClient;

public abstract class PayTest extends CustomTest {
	protected PayClient client = new PayClient(key, secret);
}
