package com.binance4j.param;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

public class MapTest {
	@Test
	void testCustom() {
		var params = new CustomParams();
		params.foo = "string";
		params.bar = 2;

		Map<String, Object> map = params.toMap();
		assertEquals(map.get("foo"), params.foo);
		assertEquals(map.get("bar"), params.bar);
		assertTrue(map.get("timestamp") != null);
		assertTrue(map.get("recvWindow") != null);
	}

	@Test
	void testNoTimestamp() {
		Map<String, Object> map = new NoTimestampParams().toMap();
		assertTrue(!map.containsKey("timestamp"));
		assertTrue(!map.containsKey("recvWindow"));
	}

	@Param(recvWindow = false, timestamp = false)
	class CustomParams implements Params {
		public String foo;
		public int bar;
	}

	@Param(recvWindow = false, timestamp = false)
	class NoTimestampParams implements Params {
	}
}
