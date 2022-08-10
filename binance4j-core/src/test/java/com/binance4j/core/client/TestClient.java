package com.binance4j.core.client;

import com.binance4j.request.GetServerTimeRequest;
import com.binance4j.request.VoidRequest;

/** API client for market endpoints */
public class TestClient extends RestClient<TestMapping> {
	/** Constructor. */
	public TestClient() {
		super(TestMapping.class, null, null);
	}

	/**
	 * Test connectivity to the Rest API.
	 */
	public VoidRequest ping() {
		return new VoidRequest(service.ping());
	}

	/**
	 * Get server Time.
	 */
	public GetServerTimeRequest time() {
		return new GetServerTimeRequest(service.time());
	}

	/**
	 * bad uri
	 */
	public VoidRequest notFound() {
		return new VoidRequest(service.notFound());
	}
}
