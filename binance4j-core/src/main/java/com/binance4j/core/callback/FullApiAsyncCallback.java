package com.binance4j.core.callback;

import com.binance4j.core.exception.ApiException;

import okhttp3.Headers;

/** A functional interface wrapping the response of a Binance API request */
@FunctionalInterface
public interface FullApiAsyncCallback<T> {
	/**
	 * Triggered when the receiving a response from the server.
	 * 
	 * @param response  API response.
	 * @param headers   The response headers.
	 * @param exception Exception response sent by the Binance API.
	 */
	void onResponse(T response, Headers headers, ApiException exception);
}