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
	/** @return The request weight. */
	int weight() default 1;

	/** @return The rate limit type. */
	RateLimitType type() default RateLimitType.IP;

	/** @return Is the request an order? */
	boolean isOrder() default false;

	/** @return Add the request timestamp to the final map? */
	boolean timestamp() default true;

	/** @return Add the receiving windows to the final map? */
	boolean recvWindow() default true;
}
