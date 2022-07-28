package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#toggleBNBBurnOnSpotTradeAndMarginInterest} params.
 * 
 * @param spotBNBBurn     Use BNB to pay for trading fees on SPOT?
 * @param interestBNBBurn Use BNB to pay for margin loan's interest?
 */
@Param
public record ToggleBurnParams(Boolean spotBNBBurn, Boolean interestBNBBurn) implements Params {
	/**
	 * Creates an instance of {@link ToggleBurnParams}.
	 */
	public ToggleBurnParams() {
		this(null, null);
	}
}