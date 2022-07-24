package com.binance4j.pay.param;

import com.binance4j.core.dto.WeightType;
import com.binance4j.core.param.IntervalParams;
import com.binance4j.pay.client.PayClient;

/** The {@link PayClient#getTrades} params */
public class TradeHistoryParams extends IntervalParams {

	/** The results limit. Default 100, max 100. */
	private Integer limit;

	/**
	 * Constructor.
	 */
	public TradeHistoryParams() {
		super(3000);
		weightType = WeightType.UID;
	}

	/**
	 * @return the limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
}