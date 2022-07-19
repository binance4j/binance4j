package com.binance4j.wallet.param;

import com.binance4j.core.param.IntervalParams;

/**
 * The parameters to get a list of SPOT, MARGIN or FUTURES daily account snapshots
 */
public class AccountSnapshotParams extends IntervalParams {
	/** The snapshot limit. min 5, max 30, default 5 */
	private int limit = 5;

	/**
	 
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
}