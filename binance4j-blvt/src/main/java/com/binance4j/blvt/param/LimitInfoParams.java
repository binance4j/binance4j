package com.binance4j.blvt.param;

import com.binance4j.blvt.client.BLVTClient;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * {@link BLVTClient#getLimitInfo} params.
 * 
 * @param tokenName Token name.
 */
@Param
public record LimitInfoParams(String tokenName) implements Params {
	/**
	 * Creates instance of the class.
	 * 
	 * @param tokenName Token name.
	 */
	public LimitInfoParams(String tokenName) {
		this.tokenName = tokenName;
	}
}