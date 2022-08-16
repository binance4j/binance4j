package com.binance4j.core.client;

import com.binance4j.core.interceptor.AuthenticationInterceptor;

/** Base interface for API Mapping. */
public interface RestMapping {
	/** The signed http full header. */
	String SIGNED_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER;
	/** The API key http full header. */
	String API_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER;
	/** Header name to determine if request is an order */
	String ORDER_H = "X-ORDER";
	/** Header to tell that this request is an order. */
	String IS_ORDER_H = ORDER_H + ": #";
	/** Header name to determine the rate limit type. */
	String RATE_LIMIT_H = "X-LIMIT";
	/**
	 * Header to tell the rate limiter interceptor to treat the request IP limited.
	 */
	String IP_H = RATE_LIMIT_H + ": IP";
	/**
	 * Header to tell the rate limiter interceptor to treat the request UID limited.
	 */
	String UID_H = RATE_LIMIT_H + ": UID";
	/**
	 * Header to tell the rate limiter interceptor to treat the request IP and UID
	 * limited.
	 */
	String IP_UID_H = RATE_LIMIT_H + ": IP_UID";
	/** The request weight header. */
	String WEIGHT_H = "X-WEIGHT";
	/** Request with a weight of one. */
	String WEIGHT_ONE_H = WEIGHT_H + ": 1";

	/**
	 * Used to add a weight header to a Retrofit mapping
	 * 
	 * @param weight THe weight of the request
	 * @return the formated header.
	 */
	static String weight(int weight) {
		return String.format(WEIGHT_H + ": %s", weight);
	}
}
