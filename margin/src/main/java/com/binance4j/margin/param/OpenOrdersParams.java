package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#getOpenOrders} params.
 * 
 * @param symbol     Symbol.
 * @param isIsolated Is the order isolated?
 */
@Param(weight = 10)
public record OpenOrdersParams(String symbol, Boolean isIsolated) implements Params {

	/**
	 * Creates an instance of {@link OpenOrdersParams}.
	 * 
	 * @param symbol Symbol.
	 */
	public OpenOrdersParams(String symbol) {
		this(symbol, null);
	}

	/**
	 * Creates an instance of {@link OpenOrdersParams}.
	 * 
	 * @param isIsolated Is the order isolated?
	 */
	public OpenOrdersParams(Boolean isIsolated) {
		this(null, isIsolated);
	}
}
