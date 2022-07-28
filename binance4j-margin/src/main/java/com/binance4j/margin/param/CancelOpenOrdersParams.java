package com.binance4j.margin.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * Request to cancel an order.
 * 
 * @param symbol     The trade symbol
 * @param isIsolated For isolated margin or nott. Default: false.
 */
@Param
public record CancelOpenOrdersParams(@Mandatory String symbol, Boolean isIsolated) implements Params {
	/**
	 * Creates an instance of {@link CancelOpenOrdersParams}.
	 * 
	 * @param symbol The trade symbol
	 */
	public CancelOpenOrdersParams(String symbol) {
		this(symbol, null);
	}
}