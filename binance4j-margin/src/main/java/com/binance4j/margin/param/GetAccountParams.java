package com.binance4j.margin.param;

import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getAccount} params. */
public class GetAccountParams extends Params {
	/** The request timestamp */
	private long timestamp = System.currentTimeMillis();

	/** Default constructor */
	public GetAccountParams() {
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
