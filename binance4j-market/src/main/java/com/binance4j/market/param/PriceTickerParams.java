package com.binance4j.market.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * The parameters to get the latest price for a symbol or symbols.
 * 
 * @param symbol Symbol.
 */
@Param(weight = 2, recvWindow = false, timestamp = false)
public record PriceTickerParams(String symbol) implements Params {
	/**
	 * Creates an instance of {@link PriceTickerParams}.
	 */
	public PriceTickerParams() {
		this(null);
	}
}