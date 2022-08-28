package com.binance4j.savings.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;

/**
 * [SavingsClient.getFlexibleProductPosition] params.
 * 
 * @param asset Asset.
 */
@Param
data class FlexibleProductPositionParams(
String asset):Params
{

	/**
	 * Creates an instance of {@link FlexibleProductPositionParams}.
	 */
	public FlexibleProductPositionParams() {
		this(null);
	}
}