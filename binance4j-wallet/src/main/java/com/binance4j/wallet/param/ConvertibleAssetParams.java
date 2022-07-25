package com.binance4j.wallet.param;

import com.binance4j.core.param.Params;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Requests assets that can be converted into BNB */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConvertibleAssetParams extends Params {
	/** The request timestamp */
	private long timestamp = System.currentTimeMillis();

	/** Constructor */
	public ConvertibleAssetParams() {
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
