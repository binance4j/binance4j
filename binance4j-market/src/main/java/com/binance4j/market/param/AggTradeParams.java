package com.binance4j.market.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.market.client.MarketClient;

/**
 * {@link MarketClient#getAggTrades} params.
 * 
 * @param symbol Symbol.
 * @param fromId Id to get aggregate trades from (inclusive). Don't provide {@link TimeFrame} if set.
 */
@Param(recvWindow = false, timestamp = false)
public record AggTradeParams(String symbol, Long fromId) implements Params {
	/**
	 * Creates an instances of {@link AggTradeParams}.
	 * 
	 * @param symbol Symbol.
	 * @param fromId Id to get aggregate trades from (inclusive). Don't provide {@link TimeFrame} if set.
	 */
	public AggTradeParams(String symbol, Long fromId) {
		this.symbol = symbol;
		this.fromId = fromId;
	}

	/**
	 * Creates an instances of {@link AggTradeParams}.
	 * 
	 * @param symbol Symbol.
	 */
	public AggTradeParams(String symbol) {
		this(symbol, null);
	}
}