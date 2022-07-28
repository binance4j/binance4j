package com.binance4j.savings.param;

import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;

/** The {@link SavingsClient#getFlexibleProductPosition} params. */
public class FlexibleProductPositionParams extends Params {
	/** The asset. */
	String asset;

	/**
	 * Constructor.
	 */
	public FlexibleProductPositionParams() {
	}

	/**
	 * Constructor.
	 * 
	 * @param asset The asset.
	 */
	public FlexibleProductPositionParams(String asset) {
		this();
		this.asset = asset;
	}
}