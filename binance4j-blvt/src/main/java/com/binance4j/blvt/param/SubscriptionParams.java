package com.binance4j.blvt.param;

import com.binance4j.blvt.client.BLVTClient;
import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;

/** The {@link BLVTClient#subscribe} params. */
public class SubscriptionParams extends Params {
	/** The token name. */
	@Mandatory
	String tokenName;
	/** Spot balance. */
	@Mandatory
	String cost;

	/**
	 * @param tokenName The token name.
	 * @param cost      Spot balance.
	 */
	public SubscriptionParams(String tokenName, String cost) {

		this.tokenName = tokenName;
		this.cost = cost;
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
	 * @return the cost
	 */
	public String getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(String cost) {
		this.cost = cost;
	}

}
