package com.binance4j.nft.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;

/**
 * A NFT deposit history request
 * <p>
 * The max interval between startTime and endTime is 90 days.
 * <p>
 * If startTime and endTime are not sent, the recent 7 days' data will be returned.
 */
@Param(weight = 3000, type = RateLimitType.UID)
public class DepositHistoryParams implements Params {
	/** The starting timestamp of the results */
	Long startTime;
	/** The ending timestamp of the results */
	Long endTime;
	/** The result size. Default 50, Max 50. */
	Integer limit;
	/** The result page. Default 1. */
	Integer page;

	/**
	 * Constructor.
	 */
	public DepositHistoryParams() {
	}

	/**
	 * @param limit The result size. Default 50, Max 50.
	 * @param page  The result page. Default 1.
	 */
	public DepositHistoryParams(int limit, int page) {
		this.limit = limit;
		this.page = page;
	}

	/**
	 * @param limit     The result size. Default 50, Max 50.
	 * @param page      The result page. Default 1.
	 * @param startTime The result start time in ms.
	 * @param endTime   The result end time in ms.
	 */
	public DepositHistoryParams(int limit, int page, long startTime, long endTime) {
		this.limit = limit;
		this.page = page;
		this.startTime = startTime;
		this.endTime = endTime;
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
