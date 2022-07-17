package com.binance4j.rebate.param;

import com.binance4j.core.param.IntervalParams;
import com.binance4j.rebate.client.RebateClient;

/**
 * The {@link RebateClient#getSpotRebateHistoryRecords} params.
 */
public class SpotRebateHistoryParams extends IntervalParams {
	/** The desired page. */
	private Integer page = 1;

	/** Constructor. */
	public SpotRebateHistoryParams() {
		super(3000);
	}

	/**
	 * Constructor.
	 * 
	 * @param page The desired page.
	 */
	public SpotRebateHistoryParams(Integer page) {
		this();
		this.page = page;
	}

	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

}
