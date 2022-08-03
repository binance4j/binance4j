package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#getMyTrades} params.
 * 
 * @param symbol     Symbol.
 * @param fromId     Search from id.
 * @param isIsolated Is isolated margin?
 */
@Param(weight = 10)
public record TradeParams(String symbol, Long fromId, Boolean isIsolated) implements Params {

	/**
	 * Creates an instance of {@link TradeParams}.
	 * 
	 * @param symbol Symbol.
	 */
	public TradeParams(String symbol) {
		this(symbol, null, null);
	}

	/**
	 * Creates an instance of {@link TradeParams}.
	 * 
	 * @param symbol Symbol.
	 * @param fromId Search from id.
	 */
	public TradeParams(String symbol, Long fromId) {
		this(symbol, fromId, null);
	}

	/**
	 * Creates an instance of {@link TradeParams}.
	 * 
	 * @param symbol     Symbol.
	 * @param isIsolated Is isolated margin?
	 */
	public TradeParams(String symbol, Boolean isIsolated) {
		this(symbol, null, isIsolated);
	}
}