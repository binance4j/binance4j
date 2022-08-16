package com.binance4j.core;

import java.io.IOException;

import com.binance4j.core.callback.ApiAsyncCallback;
import com.binance4j.core.callback.ApiAsyncCallbackAdapter;
import com.binance4j.core.callback.ApiCallback;
import com.binance4j.core.callback.ApiCallbackAdapter;
import com.binance4j.core.callback.FullApiAsyncCallback;
import com.binance4j.core.callback.FullApiAsyncCallbackAdapter;
import com.binance4j.core.client.RestMapping;
import com.binance4j.core.exception.ApiError;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.ratelimiter.RateLimiting;
import com.fasterxml.jackson.databind.ObjectMapper;

import retrofit2.Call;
import retrofit2.Response;

/** A class that receives and executes sync and async retrofit calls. */
public class Request<T> {
	private static RateLimiting limiters;
	/** The Jackson Object mapper for deserializing the Api error response. */
	private static final ObjectMapper MAPPER = new ObjectMapper();
	// static final RateLimiter
	/** The current API call. */
	private final Call<T> call;

	/**
	 * @param call Retrofit call.
	 */
	public Request(Call<T> call) {
		this.call = call;
	}

	/**
	 * Executes the request synchronously
	 * 
	 * @return The request response.
	 * @throws ApiException The exception produced with the server error response
	 */
	public T sync() throws ApiException {
		acquire();
		try {
			Response<T> response = call.execute();
			if (response.isSuccessful()) {
				return response.body();
			} else {
				ApiError error = MAPPER.readValue(response.errorBody().string(), ApiError.class);
				throw new ApiException(error);
			}
		} catch (IOException e) {
			throw new ApiException(-400, e.getMessage());
		}
	}

	/**
	 * Executes the request asynchronously
	 * 
	 * @param callback Request callback managing a success or error response.
	 * @deprecated Use {@code Request.async(ApiAsyncCallback<T> callback)}
	 */
	@Deprecated
	public void async(ApiCallback<T> callback) {
		acquire();
		call.enqueue(new ApiCallbackAdapter<>(callback));
	}

	/**
	 * Executes the request asynchronously
	 * 
	 * @param callback Request callback managing a success or error response.
	 */
	public void async(ApiAsyncCallback<T> callback) {
		acquire();
		call.enqueue(new ApiAsyncCallbackAdapter<>(callback));
	}

	/**
	 * Executes the request asynchronously
	 * 
	 * @param callback Request callback managing a success or error response.
	 */
	public void async(FullApiAsyncCallback<T> callback) {
		acquire();
		call.enqueue(new FullApiAsyncCallbackAdapter<>(callback));
	}

	/**
	 * Rate limits the API calls.
	 */
	private void acquire() {
		if (RateLimiting.isEnabled()) {
			if (limiters == null)
				limiters = new RateLimiting();

			limiters.raw().acquire(1);
			limiters.weight().acquire(getWeight());
		}
	}

	/**
	 * @return the request method
	 */
	public String getMethod() {
		return call.request().method();
	}

	/**
	 * @return the request signature
	 */
	public String getSignature() {
		String signedHeader = call.request().header(RestMapping.SIGNED_H);
		String apiHeader = call.request().header(RestMapping.API_H);

		return signedHeader != null ? signedHeader : apiHeader;
	}

	/**
	 * @return if the request is an order request.
	 */
	public boolean isOrder() {
		return call.request().header(RestMapping.ORDER_H) != null;
	}

	/**
	 * @return the request weight
	 */
	public int getWeight() {
		String weight = call.request().header(RestMapping.WEIGHT_H);
		if (weight == null) {
			return 1;
		}
		return Integer.valueOf(call.request().header(RestMapping.WEIGHT_H));
	}

	/**
	 * @return the request rateLimit
	 */
	public String getRateLimit() {
		return call.request().header(RestMapping.RATE_LIMIT_H);
	}

	/**
	 * @return the request path
	 */
	public String getPath() {
		return call.request().url().uri().getPath();
	}
}