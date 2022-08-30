package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * [MarginClient.getInterestRateHistory] params.
 * 
 * @param asset    Asset.
 * @param vipLevel VIP level.
 */
data class InterestRateHistoryParams(
asset : String, Integer vipLevel):Params
{

	/**
	 * Creates an instance of {@link InterestRateHistoryParams}.
	 * 
	 * @param asset    Asset.
	 * @param vipLevel VIP level.
	 */
	public InterestRateHistoryParams(String asset, Integer vipLevel) {
		this.asset = asset;
		this.vipLevel = vipLevel;
	}

	/**
	 * Creates an instance of {@link InterestRateHistoryParams}.
	 * 
	 * @param asset Asset.
	 */
	public InterestRateHistoryParams(String asset) {
		this(asset, null);
	}
}