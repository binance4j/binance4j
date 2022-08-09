package com.binance4j.core.callback;

import com.binance4j.core.exception.ApiException;

/** A functional interface wrapping the response of a Binance API request */
@FunctionalInterface
public interface ApiAsyncCallback<T> {
	/**
	 * Triggered when the receiving a response from the server.
	 * 
	 * @param response  API response.
	 * @param exception Exception response sent by the Binance API.
	 */
	void onResponse(T response, ApiException exception);
}