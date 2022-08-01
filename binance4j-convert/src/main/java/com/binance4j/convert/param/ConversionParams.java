package com.binance4j.convert.param;

import com.binance4j.convert.client.ConvertClient;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * {@link ConvertClient#getConversions} params.
 * 
 * @param startTime The starting time in ms.
 * @param endTime   The ending times in ms.
 * @param limit     The result size. Default 100, Max 1000.
 */
@Param(weight = 100)
public record ConversionParams(Long startTime, Long endTime, Integer limit) implements Params {
	/**
	 * Creates instance of {@link ConversionParams}.
	 * 
	 * @param startTime The starting time in ms.
	 * @param endTime   The ending times in ms.
	 * @param limit     The result size. Default 100, Max 1000.
	 */
	public ConversionParams(Long startTime, Long endTime, Integer limit) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.limit = limit;
	}

	/**
	 * Creates instance of {@link ConversionParams}.
	 * 
	 * @param startTime The starting time in ms.
	 * @param endTime   The ending times in ms.
	 */
	public ConversionParams(Long startTime, Long endTime) {
		this(startTime, endTime, null);
	}
}