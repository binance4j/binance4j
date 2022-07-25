package com.binance4j.spot.param;

import com.binance4j.core.param.Params;

/**
 * The parameters to display the user's current order count usage for all intervals.
 */
public class OrderCountParams extends Params {
	/** The request timestamp */
	private long timestamp = System.currentTimeMillis();

	/** Default constructor. */
	public OrderCountParams() {
		super(20);
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
