package com.binance4j.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.binance4j.core.Request;
import com.binance4j.core.dto.HttpMethod;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;

/** {@link Request} metadata. */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ApiRequest {
	/** The request method. */
	HttpMethod method() default HttpMethod.GET;

	/** The request signature. */
	Signature signature() default Signature.NONE;

	/** Is the request an order? */
	boolean isOrder() default false;

	/** The request weight. */
	int weight() default 1;

	/** The request rate limit. */
	RateLimitType rateLimit() default RateLimitType.IP;
}
