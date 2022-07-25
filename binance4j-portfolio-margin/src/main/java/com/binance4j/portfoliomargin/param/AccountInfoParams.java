package com.binance4j.portfoliomargin.param;

import com.binance4j.core.param.Params;
import com.binance4j.portfoliomargin.client.PortfolioMarginClient;

/** The {@link PortfolioMarginClient#getAccountInfo} params */
public class AccountInfoParams extends Params {
	/** The request timestamp */
	private long timestamp = System.currentTimeMillis();

	/**
	 * Constructor
	 */
	public AccountInfoParams() {
		super(1);
	}

	/** @return the timestamp */
	public long getTimestamp() {
		return timestamp;
	}

	/** @param timestamp the timestamp to set */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
