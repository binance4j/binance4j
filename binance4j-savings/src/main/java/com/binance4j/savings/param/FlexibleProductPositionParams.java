package com.binance4j.savings.param;

import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;

/**
 * {@link SavingsClient#getFlexibleProductPosition} params.
 * 
 * @param asset The asset.
 */
public record FlexibleProductPositionParams(String asset) implements Params {

	/**
	 * Creates an instance of {@link FlexibleProductPositionParams}.
	 */
	public FlexibleProductPositionParams() {
		this(null);
	}

}