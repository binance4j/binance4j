package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#getIsolatedMarginTierData} params.
 * 
 * @param symbol Symbol.
 * @param tier   Tier.
 */
@Param
public record IsolatedTierDataParams(String symbol, String tier) implements Params {
	/**
	 * Creates an instance of {@link IsolatedTierDataParams}.
	 * 
	 * @param symbol Symbol.
	 */
	public IsolatedTierDataParams(String symbol) {
		this(symbol, null);
	}
}
