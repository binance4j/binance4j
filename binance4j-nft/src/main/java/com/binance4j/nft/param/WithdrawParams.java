package com.binance4j.nft.param;

import com.binance4j.core.dto.WeightType;
import com.binance4j.core.param.IntervalParams;

/**
 * A NFT withdraw withdraw request
 * <p>
 * The max interval between startTime and endTime is 90 days.
 * <p>
 * If startTime and endTime are not sent, the recent 7 days' data will be returned.
 */
public class WithdrawParams extends IntervalParams {
	/** The result size. Default 50, Max 50. */
	private Integer limit = 50;
	/** The result page. Default 1. */
	private Integer page = 1;

	/**
	 
	 */
	public WithdrawParams() {
		super(3000);
		weightType = WeightType.UID;
	}

	/**
	 * @param limit The result size. Default 50, Max 50.
	 * @param page  The result page. Default 1.
	 */
	public WithdrawParams(int limit, int page) {
		this();
		this.limit = limit;
		this.page = page;
	}

	/**
	 * @param limit     The result size. Default 50, Max 50.
	 * @param page      The result page. Default 1.
	 * @param startTime The result start time in ms.
	 * @param endTime   The result end time in ms.
	 */
	public WithdrawParams(int limit, int page, long startTime, long endTime) {
		this(limit, page);
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
}