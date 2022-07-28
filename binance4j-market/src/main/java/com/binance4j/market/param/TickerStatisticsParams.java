package com.binance4j.market.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * The parameters to get the 24 hour rolling window price change statistics. Careful when accessing this with no symbol.
 * 
 * @param symbol Symbol.
 */
@Param(weight = 40, recvWindow = false, timestamp = false)
public record TickerStatisticsParams(String symbol) implements Params {
	/**
	 * Creates an instance of {@link TickerStatisticsParams}.
	 */
	public TickerStatisticsParams() {
		this(null);
	}
}