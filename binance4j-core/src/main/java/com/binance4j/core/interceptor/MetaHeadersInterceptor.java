package com.binance4j.core.interceptor;

import java.io.IOException;

import com.binance4j.core.client.RestMapping;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Interceptor to remove metadata headers before sending the request.
 */
public class MetaHeadersInterceptor implements Interceptor {

	/**
	 * Intercepts the request
	 * 
	 * @param chain Request chain.
	 */
	@Override
	public Response intercept(Chain chain) throws IOException {
		var builder = chain.request().newBuilder().removeHeader(RestMapping.ORDER_H)
				.removeHeader(RestMapping.RATE_LIMIT_H).removeHeader(RestMapping.WEIGHT_H);
		return chain.proceed(builder.build());
	}
}
