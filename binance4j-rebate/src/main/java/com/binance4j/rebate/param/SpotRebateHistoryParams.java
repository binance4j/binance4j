package com.binance4j.rebate.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.rebate.client.RebateClient;

/**
 * The {@link RebateClient#getSpotRebateHistoryRecords} params.
 */
@Param(weight = 3000, type = RateLimitType.UID)
public class SpotRebateHistoryParams implements Params {
	/** The starting timestamp of the results */
	Long startTime;
	/** The ending timestamp of the results */
	Long endTime;
	/** The desired page. */
	Integer page = 1;

	/** Constructor. */
	public SpotRebateHistoryParams() {
	}

	/**
	 * @param page The desired page.
	 */
	public SpotRebateHistoryParams(Integer page) {
		this.page = page;
	}

	/**
	 * @return the page.
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page the page to set.
	 */
	public void setPage(Integer page) {
		this.page = page;
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
