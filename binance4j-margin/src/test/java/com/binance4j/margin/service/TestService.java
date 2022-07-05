package com.binance4j.margin.service;

import com.binance4j.core.test.BaseTestService;
import com.binance4j.margin.client.MarginClient;

public class TestService extends BaseTestService {
	public static final MarginClient CLIENT = new MarginClient(KEY, SECRET);

	public TestService() {
		super();
	}
}
