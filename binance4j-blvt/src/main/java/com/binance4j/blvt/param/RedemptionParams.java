package com.binance4j.blvt.param;

import com.binance4j.blvt.client.BLVTClient;
import com.binance4j.core.param.Params;

/** The {@link BLVTClient#redeem} params. */
public class RedemptionParams extends Params {
	/** The token name. */
	String tokenName;
	/** Amount to redeem. */
	String amount;

	/**
	 * @param tokenName The token name.
	 * @param amount    Amount to redeem.
	 */
	public RedemptionParams(String tokenName, String amount) {
		super(1);
		this.tokenName = tokenName;
		this.amount = amount;
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

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
}