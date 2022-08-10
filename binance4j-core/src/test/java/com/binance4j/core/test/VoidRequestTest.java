package com.binance4j.core.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.dto.HttpMethod;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;
import com.binance4j.request.VoidRequest;

public class VoidRequestTest {

	@Test
	@DisplayName("Request values should match annotation values")
	void testVoidRequest() {
		VoidRequest req = new VoidRequest();
		assertEquals(req.getMethod(), HttpMethod.HEAD);
		assertEquals(req.getPath(), "/foo/bar/");
		assertEquals(req.getRateLimit(), RateLimitType.UID_AND_IP);
		assertEquals(req.getSignature(), Signature.USER_STREAM);
		assertEquals(req.getWeight(), 10);
	}
}
