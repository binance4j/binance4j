package com.binance4j.convert.param;

import com.binance4j.convert.client.ConvertClient;
import com.binance4j.core.param.IntervalParams;

/**
 * The {@link ConvertClient#getConversions} params.
 */
public class ConversionParams extends IntervalParams {
	/** The result size. Default 100, Max 1000. */
	private Integer limit;

	/**
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 */
	public ConversionParams(long startTime, long endTime) {
		super(100);
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param limit     The results limit.
	 */
	public ConversionParams(long startTime, long endTime, int limit) {
		this(startTime, endTime);
		this.limit = limit;
	}

	/**
	 * @return the limit.
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set.
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
}