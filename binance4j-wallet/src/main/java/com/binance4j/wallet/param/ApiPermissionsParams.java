package com.binance4j.wallet.param;

import com.binance4j.core.param.Params;

/** The parameters to get The api key permissions */
public class ApiPermissionsParams extends Params {
	/** The request timestamp */
	private long timestamp = System.currentTimeMillis();

	/** Constructor. */
	public ApiPermissionsParams() {
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
