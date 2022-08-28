package com.binance4j.savings.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;

/**
 * {@link SavingsClient#getFlexibleProductPosition} params.
 * 
 * @param asset Asset.
 */
@Param
public record FlexibleProductPositionParams(String asset) implements Params {
	/**
	 * Creates an instance of {@link FlexibleProductPositionParams}.
	 */
	public FlexibleProductPositionParams() {
		this(null);
	}
}