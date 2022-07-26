package com.binance4j.blvt.param;

import java.math.BigDecimal;

import com.binance4j.blvt.client.BLVTClient;
import com.binance4j.core.param.Params;

/** The {@link BLVTClient#subscribe} params. */
public class SubscriptionParams extends Params {
	/** The token name. */
	String tokenName;
	/** Spot balance. */
	BigDecimal cost;

	/**
	 * @param tokenName The token name.
	 * @param cost      Spot balance.
	 */
	public SubscriptionParams(String tokenName, BigDecimal cost) {
		super(1);
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
	public BigDecimal getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

}
