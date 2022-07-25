package com.binance4j.wallet.param;

import com.binance4j.core.param.Params;

/** The parameters to get the account status */
public class AccountStatusParams extends Params {
	/** The request timestamp */
	private long timestamp = System.currentTimeMillis();

	/**
	 
	 */
	public AccountStatusParams() {
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
