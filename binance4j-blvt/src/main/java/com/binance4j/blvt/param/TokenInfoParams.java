package com.binance4j.blvt.param;

import com.binance4j.blvt.client.BLVTClient;
import com.binance4j.core.param.Params;

/** The {@link BLVTClient#getTokenInfo} params. */
public class TokenInfoParams extends Params {
	/** The token name. */
	String tokenName;

	/**
	 * Constructor.
	 */
	public TokenInfoParams() {

	}

	/**
	 * @param tokenName The token name.
	 */
	public TokenInfoParams(String tokenName) {
		this();
		this.tokenName = tokenName;
	}

	/**
	 * @return the tokenName
	 */
	public String getTokenName() {
		return tokenName;
	}

	/**
	 * @param tokenName the tokenName to set
	 */
	public void setTokenName(String tokenName) {
		this.tokenName = tokenName;
	}

}
