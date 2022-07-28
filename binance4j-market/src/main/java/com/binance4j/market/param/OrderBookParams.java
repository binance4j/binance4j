package com.binance4j.market.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.market.dto.OrderBookLimit;

/**
 * The parameters to get the market depth of a symbol.
 * 
 * @param symbol Trading pair we want the depth.
 * @param limit  Market depth size.
 */
@Param(recvWindow = false, timestamp = false)
public record OrderBookParams(@Mandatory String symbol, OrderBookLimit limit) implements Params {
	/**
	 * Creates an instance of {@link OrderBookParams}.
	 * 
	 * @param symbol Trading pair we want the depth.
	 */
	public OrderBookParams(String symbol) {
		this(symbol, null);
	}
}