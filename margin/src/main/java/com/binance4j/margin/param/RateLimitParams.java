package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#getRateLimit} params.
 * 
 * @param symbol     Symbol.
 * @param isIsolated Is it isolated?
 */
@Param(weight = 20)
public record RateLimitParams(String symbol, Boolean isIsolated) implements Params {
	/**
	 * Creates an instance of the class.
	 * 
	 * @param symbol     Symbol.
	 * @param isIsolated Is it isolated?
	 */
	public RateLimitParams(String symbol, Boolean isIsolated) {
		this.symbol = symbol;
		this.isIsolated = isIsolated;
	}

	/**
	 * Creates an instance of the class.
	 * 
	 * @param symbol Symbol.
	 */
	public RateLimitParams(String symbol) {
		this(symbol, null);
	}
}