package com.binance4j.spot.param;

import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;

/**
 * {@link SpotClient#getOpenOrders} params.
 * 
 * @param symbol The pair we want the open orders.
 */
public record OpenOrdersStatusParams(String symbol) implements Params {
	/**
	 * Creates an instance of {@link OpenOrdersStatusParams}.
	 */
	public OpenOrdersStatusParams() {
		this(null);
	}
}