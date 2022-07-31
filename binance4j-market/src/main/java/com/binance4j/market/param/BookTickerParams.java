package com.binance4j.market.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.market.client.MarketClient;

/**
 * {@link MarketClient#getBookTicker} params.
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