package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#getAllOrders} params.
 * 
 * @param symbol     Order symbol.
 * @param isIsolated Is the order isolated?
 * @param orderId    Order id.
 */
@Param(weight = 200)
public record AllOrdersParams(String symbol, Long orderId, Boolean isIsolated) implements Params {
	/**
	 * Creates an instance of {@link AllOrdersParams}.
	 * 
	 * @param symbol Order symbol
	 */
	public AllOrdersParams(String symbol) {
		this(symbol, null, null);
	}

	/**
	 * Creates an instance of {@link AllOrdersParams}.
	 * 
	 * @param symbol  Order symbol
	 * @param orderId Order id.
	 */
	public AllOrdersParams(String symbol, Long orderId) {
		this(symbol, orderId, null);
	}

	/**
	 * Creates an instance of {@link AllOrdersParams}.
	 * 
	 * @param symbol     Order symbol
	 * @param isIsolated Is the order isolated?
	 */
	public AllOrdersParams(String symbol, Boolean isIsolated) {
		this(symbol, null, isIsolated);
	}
}