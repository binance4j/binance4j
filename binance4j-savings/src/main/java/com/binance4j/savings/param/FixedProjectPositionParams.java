package com.binance4j.savings.param;

import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.FixedProjectPositionStatus;

/** The {@link SavingsClient#getFixedProjectPosition} params. */
public class FixedProjectPositionParams extends Params {
	/** Asset. */
	String asset;
	/** Project id. */
	String projectId;
	/** Status. */
	FixedProjectPositionStatus status;

	/**
	 * Constructor.
	 */
	public FixedProjectPositionParams() {
		super(1);
	}
}