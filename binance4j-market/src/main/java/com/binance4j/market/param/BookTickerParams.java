package com.binance4j.market.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * The parameters to get the the best price/quantity on the order book for a symbol or symbols.
 * 
 * @param symbol Symbol.
 */
@Param(weight = 2, recvWindow = false, timestamp = false)
public record BookTickerParams(String symbol) implements Params {
	/**
	 * Creates an instance of {@link BookTickerParams}.
	 */
	public BookTickerParams() {
		this(null);
	}
}