package com.binance4j.wallet.param;

import com.binance4j.core.param.Params;

/** The parameters to get dust operations (assets to BNB) logs */
public class DustLogParams extends Params {
	/** The starting timestamp of the results */
	Long startTime;
	/** The ending timestamp of the results */
	Long endTime;

	/** Default constructor. */
	public DustLogParams() {
		super(1);
	}

	/** @return the startTime */
	public Long getStartTime() {
		return startTime;
	}

	/** @param startTime the startTime to set */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	/** @return the endTime */
	public Long getEndTime() {
		return endTime;
	}

	/** @param endTime the endTime to set */
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
}
