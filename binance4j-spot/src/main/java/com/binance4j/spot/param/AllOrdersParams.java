package com.binance4j.spot.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;

/**
 * {@link SpotClient#getAllOrders} params.
 * 
 * @param symbol  The trading pair we want the orders.
 * @param orderId If orderId is set, it will get orders &gt;= that orderId. Otherwise, most recent orders are returned.
 *                    If startTime and/or endTime provided, orderId is not required.
 */
@Param(weight = 10)
public record AllOrdersParams(@Mandatory String symbol, Long orderId) implements Params {
	/**
	 * Creates an instance of {@link AllOrdersParams}.
	 */
	public AllOrdersParams(String symbol) {
		this(symbol, null);
	}
}