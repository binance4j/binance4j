package com.binance4j.core.callback;

import com.binance4j.core.exception.ApiException;

/** A functional interface wrapping the response of a Binance API request */
@FunctionalInterface
public interface ApiCallback<T> {
	/**
	 * Triggered when the HTTP response code is in the range [200...300))
	 * 
	 * @param response API response.
	 */
	void onResponse(T response);

	/**
	 * Triggered when the HTTP response code is outside the range [200...300))
	 * 
	 * @param exception Exception response sent by the Binance API.
	 */
	default void onFailure(ApiException exception) {
	}
}