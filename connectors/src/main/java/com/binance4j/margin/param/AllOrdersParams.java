package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * [MarginClient.getAllOrders] params.
 * 
 * @param symbol     Order symbol.
 * @param isIsolated Is the order isolated?
 * @param orderId    Order id.
 */
data class AllOrdersParams(
symbol : String, Long orderId,
Boolean isIsolated):Params
{

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