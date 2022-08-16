package com.binance4j.core.client;

import com.binance4j.core.interceptor.AuthenticationInterceptor;

/** Base interface for API Mapping. */
public interface RestMapping {
	/** The signed http full header. */
	String SIGNED_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER;
	/** The API key http full header. */
	String API_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER;
}
