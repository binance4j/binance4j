package com.binance4j.blvt.param;

import com.binance4j.blvt.client.BLVTClient;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * The {@link BLVTClient#getLimitInfo} params.
 * 
 * @param tokenName The token name.
 */
@Param
public record LimitInfoParams(String tokenName) implements Params {
	/** Creates instance of {@link LimitInfoParams}. */
	public LimitInfoParams() {
		this(null);
	}
}