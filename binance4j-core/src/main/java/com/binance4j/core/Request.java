package com.binance4j.core;

import java.io.IOException;

import com.binance4j.core.annotation.ApiRequest;
import com.binance4j.core.callback.ApiAsyncCallback;
import com.binance4j.core.callback.ApiAsyncCallbackAdapter;
import com.binance4j.core.callback.ApiCallback;
import com.binance4j.core.callback.ApiCallbackAdapter;
import com.binance4j.core.callback.FullApiAsyncCallback;
import com.binance4j.core.callback.FullApiAsyncCallbackAdapter;
import com.binance4j.core.dto.HttpMethod;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;
import com.binance4j.core.exception.ApiError;
import com.binance4j.core.exception.ApiException;
import com.fasterxml.jackson.databind.ObjectMapper;

import retrofit2.Call;
import retrofit2.Response;

/** A class that receives and executes sync and async retrofit calls. */
public abstract class Request<T> {
	/** The Jackson Object mapper for deserializing the Api error response. */
	static final ObjectMapper MAPPER = new ObjectMapper();
	// static final RateLimiter
	/** The current API call. */
	final Call<T> call;

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
		call.enqueue(new ApiCallbackAdapter<>(callback));
	}

	/**
	 * Executes the request asynchronously
	 * 
	 * @param callback Request callback managing a success or error response.
	 */
	public void async(ApiAsyncCallback<T> callback) {
		call.enqueue(new ApiAsyncCallbackAdapter<>(callback));
	}

	/**
	 * Executes the request asynchronously
	 * 
	 * @param callback Request callback managing a success or error response.
	 */
	public void async(FullApiAsyncCallback<T> callback) {
		call.enqueue(new FullApiAsyncCallbackAdapter<>(callback));
	}

	/**
	 * @return the request method
	 */
	public HttpMethod getMethod() {
		try {
			return !getClass().isAnnotationPresent(ApiRequest.class)
					? (HttpMethod) ApiRequest.class.getDeclaredMethod("method").getDefaultValue()
					: getClass().getAnnotation(ApiRequest.class).method();
		} catch (NoSuchMethodException | SecurityException e) {
			return HttpMethod.GET;
		}
	}

	/**
	 * @return the request signature
	 */
	public Signature getSignature() {
		try {
			return !getClass().isAnnotationPresent(ApiRequest.class)
					? (Signature) ApiRequest.class.getDeclaredMethod("signature").getDefaultValue()
					: getClass().getAnnotation(ApiRequest.class).signature();
		} catch (NoSuchMethodException | SecurityException e) {
			return Signature.NONE;
		}
	}

	/**
	 * @return if the request is an order request.
	 */
	public boolean isOrder() {
		try {
			return !getClass().isAnnotationPresent(ApiRequest.class)
					? (boolean) ApiRequest.class.getDeclaredMethod("isOrder").getDefaultValue()
					: getClass().getAnnotation(ApiRequest.class).isOrder();
		} catch (NoSuchMethodException | SecurityException e) {
			return false;
		}
	}

	/**
	 * @return the request weight
	 */
	public int getWeight() {
		try {
			return !getClass().isAnnotationPresent(ApiRequest.class)
					? (int) ApiRequest.class.getDeclaredMethod("weight").getDefaultValue()
					: getClass().getAnnotation(ApiRequest.class).weight();
		} catch (NoSuchMethodException | SecurityException e) {
			return 1;
		}
	}

	/**
	 * @return the request rateLimit
	 */
	public RateLimitType getRateLimit() {
		try {
			return !getClass().isAnnotationPresent(ApiRequest.class)
					? (RateLimitType) ApiRequest.class.getDeclaredMethod("rateLimit").getDefaultValue()
					: getClass().getAnnotation(ApiRequest.class).rateLimit();
		} catch (NoSuchMethodException | SecurityException e) {
			return RateLimitType.IP;
		}
	}

	/**
	 * @return the request path
	 */
	public String getPath() {
		try {
			return !getClass().isAnnotationPresent(ApiRequest.class)
					? (String) ApiRequest.class.getDeclaredMethod("path").getDefaultValue()
					: getClass().getAnnotation(ApiRequest.class).path();
		} catch (NoSuchMethodException | SecurityException e) {
			return "";
		}
	}
}