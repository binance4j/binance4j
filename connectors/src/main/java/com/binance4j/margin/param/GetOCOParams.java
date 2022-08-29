package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * [MarginClient.getOCO] params.
 * 
 * @param symbol            Symbol. Mandatory for isolated margin, not supported
 *                          for cross margin.
 * @param isIsolated        Is the order isolated?
 * @param orderListId       Either {@code orderListId} or
 *                          {@code origClientOrderId} must be provided.
 * @param origClientOrderId Either {@code orderListId} or
 *                          {@code origClientOrderId} must be provided.
 */
data class GetOCOParams(
String symbol, Boolean isIsolated,
Long orderListId, String origClientOrderId):Params
{

	/**
	 * Creates an instance of {@link GetOCOParams}.
	 * 
	 * @param symbol     Symbol. Mandatory for isolated margin, not supported for
	 *                   cross margin.
	 * @param isIsolated Is the order isolated?
	 */
	public GetOCOParams(String symbol, Boolean isIsolated) {
		this(symbol, isIsolated, null, null);
	}

	/**
	 * Creates an instance of {@link GetOCOParams}.
	 * 
	 * @param isIsolated Is the order isolated?
	 */
	public GetOCOParams(Boolean isIsolated) {
		this(null, isIsolated, null, null);
	}
}