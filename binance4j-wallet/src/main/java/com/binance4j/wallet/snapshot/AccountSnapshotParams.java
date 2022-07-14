package com.binance4j.wallet.snapshot;

import com.binance4j.core.param.IntervalParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The parameters to get a list of SPOT, MARGIN or FUTURES daily account
 * snapshots
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AccountSnapshotParams extends IntervalParams {
	/** The snapshot limit. min 5, max 30, default 5 */
	private int limit = 5;

	/**
	 
	 */
	public AccountSnapshotParams() {
		super(2400);
	}

	/**
	 *
	 * 
	 * @param limit The snapshot limit. min 5, max 30, default 5/
	 */
	public AccountSnapshotParams(int limit) {
		this();
		this.limit = limit;
	}
}
