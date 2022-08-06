package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#getInterestRateHistory} params.
 * 
 * @param asset    Asset.
 * @param vipLevel VIP level.
 */
@Param
public record InterestRateHistoryParams(String asset, Integer vipLevel) implements Params {
	/**
	 * Creates an instance of {@link InterestRateHistoryParams}.
	 * 
	 * @param asset Asset.
	 */
	public InterestRateHistoryParams(String asset) {
		this(asset, null);
	}
}