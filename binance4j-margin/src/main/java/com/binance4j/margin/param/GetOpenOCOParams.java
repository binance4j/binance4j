package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#getOpenOCO} params.
 * 
 * @param symbol     Isolated symbol. Not supported for cross margin.
 * @param isIsolated Is the order isolated?
 */
@Param(weight = 10)
public record GetOpenOCOParams(String symbol, Boolean isIsolated) implements Params {
	/**
	 * Creates an instance of {@link GetOpenOCOParams}.
	 */
	public GetOpenOCOParams() {
		this(null, null);
	}

	/**
	 * Creates an instance of {@link GetOpenOCOParams}.
	 * 
	 * @param isIsolated Is the order isolated?
	 */
	public GetOpenOCOParams(Boolean isIsolated) {
		this(null, isIsolated);
	}

	/**
	 * Creates an instance of {@link GetOpenOCOParams}.
	 * 
	 * @param symbol Isolated symbol. {@code isIsolated} set to true.
	 */
	public GetOpenOCOParams(String symbol) {
		this(symbol, true);
	}
}