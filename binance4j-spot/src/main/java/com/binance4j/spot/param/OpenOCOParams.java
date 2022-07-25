package com.binance4j.spot.param;

import com.binance4j.core.param.Params;

/** Request to fetch open OCO orders */
public class OpenOCOParams extends Params {
	/** The request timestamp */
	private long timestamp = System.currentTimeMillis();

	/** Constructor */
	public OpenOCOParams() {
		super(3);
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
