package com.binance4j.core.client;

import com.binance4j.core.Request;

/** API client for market endpoints */
public class TestClient extends RestClient<TestMapping> {
	/** Constructor. */
	public TestClient() {
		super(TestMapping.class, null, null);
	}

	/**
	 * Test connectivity to the Rest API.
	 */
	public Request<Void> ping() {
		return new Request<>(service.ping());
	}
}
