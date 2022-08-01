package com.binance4j.blvt.param;

import com.binance4j.blvt.client.BLVTClient;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * {@link BLVTClient#getTokenInfo} params.
 * 
 * @param tokenName The token name.
 */
@Param
public record TokenInfoParams(String tokenName) implements Params {
	/**
	 * Creates instance of the class.
	 * 
	 * @param tokenName The token name.
	 */
	public TokenInfoParams(String tokenName) {
		this.tokenName = tokenName;
	}

	/** Creates instance of the class. */
	public TokenInfoParams() {
		this(null);
	}
}