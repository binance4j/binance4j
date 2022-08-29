package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * [MarginClient.getIsolatedMarginTierData] params.
 * 
 * @param symbol Symbol.
 * @param tier   Tier.
 */
data class IsolatedTierDataParams(
String symbol, String tier):Params
{

	/**
	 * Creates an instance of {@link IsolatedTierDataParams}.
	 * 
	 * @param symbol Symbol.
	 * @param tier   Tier.
	 */
	public IsolatedTierDataParams(String symbol, String tier) {
		this.symbol = symbol;
		this.tier = tier;
	}

	/**
	 * Creates an instance of {@link IsolatedTierDataParams}.
	 * 
	 * @param symbol Symbol.
	 */
	public IsolatedTierDataParams(String symbol) {
		this(symbol, null);
	}
}
