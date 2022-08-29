package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * [MarginClient.getOrder] params.
 * 
 * @param symbol            Symbol.
 * @param orderId           Order id.
 * @param isIsolated        Is the order isolated?
 * @param origClientOrderId Origin client order id.
 */
data class OrderParams(
String symbol, Long orderId,
Boolean isIsolated, String origClientOrderId):Params
{

	/**
	 * Creates an instance of {@link OrderParams}.
	 * 
	 * @param symbol Symbol.
	 */
	public OrderParams(String symbol) {
		this(symbol, null, null, null);
	}

	/**
	 * Creates an instance of {@link OrderParams}.
	 * 
	 * @param symbol  Symbol.
	 * @param orderId Order id.
	 */
	public OrderParams(String symbol, long orderId) {
		this(symbol, orderId, null, null);
	}

	/**
	 * Creates an instance of {@link OrderParams}.
	 * 
	 * @param symbol            Symbol.
	 * @param origClientOrderId Origin client order id.
	 */
	public OrderParams(String symbol, String origClientOrderId) {
		this(symbol, null, null, origClientOrderId);
	}

	/**
	 * Creates an instance of {@link OrderParams}.
	 * 
	 * @param symbol     Symbol.
	 * @param isIsolated Is the order isolated?
	 */
	public OrderParams(String symbol, Boolean isIsolated) {
		this(symbol, null, isIsolated, null);
	}

	/**
	 * Creates an instance of {@link OrderParams}.
	 * 
	 * @param symbol     Symbol.
	 * @param orderId    Order id.
	 * @param isIsolated Is the order isolated?
	 */
	public OrderParams(String symbol, long orderId, Boolean isIsolated) {
		this(symbol, orderId, isIsolated, null);
	}
}