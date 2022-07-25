package com.binance4j.wallet.param;

import com.binance4j.core.param.Params;

/**
 * The parameters to get information of coins (available for deposit and withdraw) for user.
 */
public class CoinInformationParams extends Params {
	/** The request timestamp */
	private long timestamp = System.currentTimeMillis();

	/**
	 
	 */
	public CoinInformationParams() {
		super(10);
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