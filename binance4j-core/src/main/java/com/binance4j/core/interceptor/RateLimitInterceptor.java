package com.binance4j.core.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Interceptor that rate limits the clients requests
 */
public class RateLimitInterceptor implements Interceptor {

	/**
	 * Intercepts the request
	 * 
	 * @param chain Request chain.
	 */
	@Override
	public Response intercept(Chain chain) throws IOException {
		return chain.proceed(chain.request());
	}
}
