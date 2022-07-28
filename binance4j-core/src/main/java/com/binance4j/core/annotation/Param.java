package com.binance4j.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;

/** {@link Params} metadata. */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Param {
	int weight() default 1;

	RateLimitType type() default RateLimitType.IP;

	boolean isOrder() default false;

	boolean timestamp() default true;

	boolean recvWindow() default true;
}
