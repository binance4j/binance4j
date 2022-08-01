package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#getAllOrders} params.
 * 
 * @param symbol     The order symbol.
 * @param isIsolated Is the order isolated?
 * @param orderId    The order id.
 */
@Param(weight = 200)
public record AllOrdersParams(String symbol, Long orderId, Boolean isIsolated) implements Params {
	/**
	 * Creates an instance of {@link AllOrdersParams}.
	 * 
	 * @param symbol The order symbol
	 */
	public AllOrdersParams(String symbol) {
		this(symbol, null, null);
	}

	/**
	 * Creates an instance of {@link AllOrdersParams}.
	 * 
	 * @param symbol  The order symbol
	 * @param orderId The order id.
	 */
	public AllOrdersParams(String symbol, Long orderId) {
		this(symbol, orderId, null);
	}

	/**
	 * Creates an instance of {@link AllOrdersParams}.
	 * 
	 * @param symbol     The order symbol
	 * @param isIsolated Is the order isolated?
	 */
	public AllOrdersParams(String symbol, Boolean isIsolated) {
		this(symbol, null, isIsolated);
	}
}