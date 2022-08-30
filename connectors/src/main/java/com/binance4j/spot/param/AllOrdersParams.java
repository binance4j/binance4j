package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;

/**
 * [SpotClient.getAllOrders] params.
 * 
 * @param symbol  Trading pair we want the orders.
 * @param orderId If orderId is set, it will get orders &gt;= that orderId. Otherwise, most recent orders are returned.
 *                    If startTime and/or endTime provided, orderId is not required.
 */
data class AllOrdersParams(
symbol : String, Long orderId):Params
{

	/**
	 * Creates an instance of {@link AllOrdersParams}.
	 * 
	 * @param symbol  Trading pair we want the orders.
	 * @param orderId If orderId is set, it will get orders &gt;= that orderId.
	 *                Otherwise, most recent orders are returned.
	 *                If startTime and/or endTime provided, orderId is not required.
	 */
	public AllOrdersParams(String symbol, Long orderId) {
		this.symbol = symbol;
		this.orderId = orderId;
	}

	/**
	 * Creates an instance of {@link AllOrdersParams}.
	 * 
	 * @param symbol Trading pair we want the orders.
	 */
	public AllOrdersParams(String symbol) {
		this(symbol, null);
	}
}