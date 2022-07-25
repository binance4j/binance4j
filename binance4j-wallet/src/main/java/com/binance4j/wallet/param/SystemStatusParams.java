package com.binance4j.wallet.param;

import com.binance4j.core.param.Params;

/** The request to obtain the system status */
public class SystemStatusParams extends Params {
	/** The request timestamp */
	private long timestamp = System.currentTimeMillis();

	/** Constructor. */
	public SystemStatusParams() {
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
