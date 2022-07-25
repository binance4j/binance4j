package com.binance4j.spot.param;

import com.binance4j.core.param.Params;

/** The parameters to get the current account information. */
public class AccountParams extends Params {
	/** The request timestamp */
	private long timestamp = System.currentTimeMillis();

	/** Constructor. */
	public AccountParams() {
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
