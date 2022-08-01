package com.binance4j.savings.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.FixedProjectPositionStatus;

/**
 * {@link SavingsClient#getFixedProjectPosition} params.
 * 
 * @param asset     Asset.
 * @param projectId Project id.
 * @param status    Status.
 */
@Param
public record FixedProjectPositionParams(String asset, String projectId, FixedProjectPositionStatus status) implements Params {
	/**
	 * Creates an instance of {@link FixedProjectPositionParams}.
	 */
	public FixedProjectPositionParams() {
		this(null, null, null);
	}

	/**
	 * Creates an instance of {@link FixedProjectPositionParams}.
	 * 
	 * @param asset  Asset.
	 * @param status Status.
	 */
	public FixedProjectPositionParams(String asset, FixedProjectPositionStatus status) {
		this(asset, null, status);
	}

	/**
	 * Creates an instance of {@link FixedProjectPositionParams}.
	 * 
	 * @param status Status.
	 */
	public FixedProjectPositionParams(FixedProjectPositionStatus status) {
		this(null, null, status);
	}

	/**
	 * Creates an instance of {@link FixedProjectPositionParams}.
	 * 
	 * @param asset Asset.
	 */
	public FixedProjectPositionParams(String asset) {
		this(asset, null, null);
	}

	/**
	 * Creates an instance of {@link FixedProjectPositionParams}.
	 * 
	 * @param asset     Asset.
	 * @param projectId Project id.
	 */
	public FixedProjectPositionParams(String asset, String projectId) {
		this(asset, projectId, null);
	}
}