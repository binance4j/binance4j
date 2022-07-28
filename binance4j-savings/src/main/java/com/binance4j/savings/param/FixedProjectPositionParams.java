package com.binance4j.savings.param;

import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.FixedProjectPositionStatus;

/** {@link SavingsClient#getFixedProjectPosition} params. */
public class FixedProjectPositionParams implements Params {
	/** Asset. */
	String asset;
	/** Project id. */
	String projectId;
	/** Status. */
	FixedProjectPositionStatus status;
}