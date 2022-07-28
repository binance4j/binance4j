package com.binance4j.nft.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;

/**
 * A NFT withdraw withdraw request
 * <p>
 * The max interval between startTime and endTime is 90 days.
 * <p>
 * If startTime and endTime are not sent, the recent 7 days' data will be returned.
 */
@Param(weight = 3000, type = RateLimitType.UID)
public class AssetParams implements Params {
	/** The result size. Default 50, Max 50. */
	Integer limit;
	/** The result page. Default 1. */
	Integer page;

	/** Constructor. */
	public AssetParams() {
	}

	/**
	 * @param limit The result size. Default 50, Max 50.
	 * @param page  The result page. Default 1.
	 */
	public AssetParams(int limit, int page) {
		this.limit = limit;
		this.page = page;
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