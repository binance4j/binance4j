package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#getInterestRateHistory} params.
 * 
 * @param asset    The asset.
 * @param vipLevel The VIP level.
 */
@Param
public record InterestRateHistoryParams(String asset, Integer vipLevel) implements Params {
	/**
	 * Creates an instance of {@link InterestRateHistoryParams}.
	 * 
	 * @param asset The asset.
	 */
	public InterestRateHistoryParams(String asset) {
		this(asset, null);
	}
}