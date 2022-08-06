package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;

/**
 * {@link SpotClient#cancelOpenOrders} params.
 * 
 * @param symbol     Trade symbol.
 * @param isIsolated for isolated margin or not. Default: false.
 */
@Param
public record CancelOpenOrdersParams(String symbol, Boolean isIsolated) implements Params {
	/**
	 * Creates an instance of {@link CancelOpenOrdersParams}.
	 * 
	 * @param symbol Trade symbol.
	 */
	public CancelOpenOrdersParams(String symbol) {
		this(symbol, null);
	}
}