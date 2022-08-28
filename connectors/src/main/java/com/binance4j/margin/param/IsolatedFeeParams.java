package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * [MarginClient.getIsolatedFeeData] params.
 * 
 * @param symbol   Asset.
 * @param vipLevel Vip level.
 */
@Param
data class IsolatedFeeParams(
String symbol, Integer vipLevel):Params
{

	/**
	 * Creates an instance of {@link InterestRateHistoryParams}.
	 * 
	 * @param symbol Asset.
	 */
	public IsolatedFeeParams(String symbol) {
		this(symbol, null);
	}

	/**
	 * Creates an instance of {@link InterestRateHistoryParams}.
	 * 
	 * @param vipLevel Vip level.
	 */
	public IsolatedFeeParams(Integer vipLevel) {
		this(null, vipLevel);
	}
}