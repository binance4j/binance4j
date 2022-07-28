package com.binance4j.wallet.param;

import com.binance4j.core.param.Params;

/**
 * The parameters to get a list of SPOT, MARGIN or FUTURES daily account snapshots
 */
public class AccountSnapshotParams extends Params {
	/** The starting timestamp of the results */
	Long startTime;
	/** The ending timestamp of the results */
	Long endTime;
	/** The snapshot limit. min 5, max 30, default 5 */
	Integer limit;

	/**
	 * Constructor.
	 */
	public AccountSnapshotParams() {
		super(2400);
	}

	/**
	 * @param limit The snapshot limit. min 5, max 30, default 5/.
	 */
	public AccountSnapshotParams(int limit) {
		this();
		this.limit = limit;
	}

	/**
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(int limit) {
		this.limit = limit;
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