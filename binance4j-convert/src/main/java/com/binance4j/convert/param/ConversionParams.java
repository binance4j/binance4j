package com.binance4j.convert.param;

import com.binance4j.convert.client.ConvertClient;
import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;

/**
 * The {@link ConvertClient#getConversions} params.
 */
public class ConversionParams extends Params {
	/** The starting timestamp of the results */
	@Mandatory
	Long startTime;
	/** The ending timestamp of the results */
	@Mandatory
	Long endTime;

	/** The result size. Default 100, Max 1000. */
	Integer limit;

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

	/** @return the startTime */
	public Long getStartTime() {
		return startTime;
	}

	/** @param startTime the startTime to set */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	/** @return the endTime */
	public Long getEndTime() {
		return endTime;
	}

	/** @param endTime the endTime to set */
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
}