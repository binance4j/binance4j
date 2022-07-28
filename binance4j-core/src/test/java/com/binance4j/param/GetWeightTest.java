package com.binance4j.param;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;

public class GetWeightTest {

	@Test
	@DisplayName("Annotated class must match default values")
	void testDefault() {
		var params = new DefaultWeightParams();
		Param weight = params.getClass().getAnnotation(Param.class);
		assertEquals(weight.type(), RateLimitType.IP);
		assertEquals(weight.weight(), 1);
	}

	@Test
	@DisplayName("Annotated class must match custom values")
	void testCustom() {
		var params = new CustomWeightParams();
		Param weight = params.getClass().getAnnotation(Param.class);
		assertEquals(weight.type(), RateLimitType.UID);
		assertEquals(weight.weight(), 10);
	}

	@Test
	@DisplayName("Inherited class with custom values must match annotation values")
	void testCustomInherited() {
		var params = new InheritedWeightParams();
		assertEquals(params.type(), RateLimitType.UID_AND_IP);
		assertEquals(params.weight(), 35);
	}

	@Test
	@DisplayName("Inherited class with no annotation must match interface values")
	void testDefaultInherited() {
		var params = new DefaultInheritedWeightParams();
		assertEquals(params.type(), RateLimitType.IP);
		assertEquals(params.weight(), 1);
	}

	@Param
	public class DefaultWeightParams {
	}

	@Param(weight = 10, type = RateLimitType.UID)
	public class CustomWeightParams {
	}

	public interface Params {
		public default int weight() {
			try {
				return getClass().getAnnotation(Param.class).weight();
			} catch (Exception e) {
				return 1;
			}
		}

		public default RateLimitType type() {
			try {
				return getClass().getAnnotation(Param.class).type();
			} catch (Exception e) {
				return RateLimitType.IP;
			}
		}
	}

	public class DefaultInheritedWeightParams implements Params {
	}

	@Param(weight = 35, type = RateLimitType.UID_AND_IP)
	public class InheritedWeightParams implements Params {
	}
}
