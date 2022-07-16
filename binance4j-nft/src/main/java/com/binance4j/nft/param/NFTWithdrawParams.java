package com.binance4j.nft.param;

import com.binance4j.core.param.IntervalParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A NFT withdraw withdraw request
 * <p>
 * The max interval between startTime and endTime is 90 days.
 * <p>
 * If startTime and endTime are not sent, the recent 7 days' data will be returned.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NFTWithdrawParams extends IntervalParams {
	/** The result size. Default 50, Max 50. */
	private Integer limit = 50;
	/** The result page. Default 1. */
	private Integer page = 1;

	/**
	 
	 */
	public NFTWithdrawParams() {
		super(3000);
	}

	/**
	 *
	 * 
	 * @param limit The result size. Default 50, Max 50.
	 * @param page  The result page. Default 1.
	 */
	public NFTWithdrawParams(int limit, int page) {
		this();
		this.limit = limit;
		this.page = page;
	}

	/**
	 *
	 * 
	 * @param limit     The result size. Default 50, Max 50.
	 * @param page      The result page. Default 1.
	 * @param startTime The result start time in ms
	 * @param endTime   The result end time in ms
	 */
	public NFTWithdrawParams(int limit, int page, long startTime, long endTime) {
		this(limit, page);
		this.startTime = startTime;
		this.endTime = endTime;
	}
}
