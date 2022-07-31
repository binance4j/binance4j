package com.binance4j.market.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.market.client.MarketClient;

/**
 * {@link MarketClient#get24hTickerStatistics} params.
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