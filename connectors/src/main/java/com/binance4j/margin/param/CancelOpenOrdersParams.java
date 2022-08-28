package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * [MarginClient.cancelOpenOrders] params.
 * 
 * @param symbol     Trade symbol
 * @param isIsolated For isolated margin or nott. Default: false.
 */
@Param
data class CancelOpenOrdersParams(
String symbol, Boolean isIsolated):Params
{

	/**
	 * Creates an instance of {@link CancelOpenOrdersParams}.
	 * 
	 * @param symbol Trade symbol
	 */
	public CancelOpenOrdersParams(String symbol) {
		this(symbol, null);
	}
}