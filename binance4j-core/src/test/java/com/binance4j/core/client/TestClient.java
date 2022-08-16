package com.binance4j.core.client;

import com.binance4j.core.Request;
import com.binance4j.core.pojo.ServerTimeResponse;

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

	/**
	 * Get server Time.
	 */
	public Request<ServerTimeResponse> time() {
		return new Request<>(service.time());
	}

	/**
	 * bad uri
	 */
	public Request<Void> notFound() {
		return new Request<>(service.notFound());
	}
}
