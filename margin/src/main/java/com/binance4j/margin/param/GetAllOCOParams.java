package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.margin.client.MarginClient;

/**
 * [MarginClient.getAllOCO] params.
 * 
 * @param symbol     Mandatory for isolated margin, not supported for cross
 *                   margin.
 * @param fromId     If supplied, don't provide {@link TimeFrame}
 * @param isIsolated Is the order isolated?
 */
@Param
data class GetAllOCOParams(
String symbol, Long fromId,
Boolean isIsolated):Params
{

	/**
	 * Creates an instance of {@link GetAllOCOParams}.
	 * 
	 * @param fromId If supplied, don't provide {@link TimeFrame}
	 */
	public GetAllOCOParams(Long fromId) {
		this(null, fromId, true);
	}

	/**
	 * Creates an instance of {@link GetAllOCOParams}.
	 * 
	 * @param symbol Isolated symbol. {@code isIsolated} automatically set to
	 *               {@code true}
	 */
	public GetAllOCOParams(String symbol) {
		this(symbol, null, true);
	}

	/**
	 * Creates an instance of {@link GetAllOCOParams}.
	 * 
	 * @param symbol Isolated symbol. {@code isIsolated} automatically set to
	 *               {@code true}
	 * @param fromId If supplied, don't provide {@link TimeFrame}
	 */
	public GetAllOCOParams(String symbol, Long fromId) {
		this(symbol, fromId, true);
	}
}