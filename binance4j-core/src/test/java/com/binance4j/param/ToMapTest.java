package com.binance4j.param;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.param.CallParams;

public class ToMapTest {

	@Test
	@DisplayName("Child class toMap result must match ")
	void test() {
		var params = new CustomParams();
		params.setFoo("string");
		params.setBar(2);

		Map<String, Object> map = params.toMap();
		assertEquals(map.get("foo"), params.getFoo());
		assertEquals(map.get("bar"), params.getBar());
		assertTrue(map.get("timestamp") != null);
		assertTrue(map.get("recvWindow") != null);
	}

	class CustomParams implements CallParams {
		private String foo;
		private int bar;

		/**
		 * @return the foo
		 */
		public String getFoo() {
			return foo;
		}

		/**
		 * @param foo the foo to set
		 */
		public void setFoo(String foo) {
			this.foo = foo;
		}

		/**
		 * @return the bar
		 */
		public int getBar() {
			return bar;
		}

		/**
		 * @param bar the bar to set
		 */
		public void setBar(int bar) {
			this.bar = bar;
		}

	}
}
