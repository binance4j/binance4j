package com.binance4j.loan.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.loan.client.LoanClient;
import com.binance4j.loan.dto.LoanIncomeType;

/** The {@link LoanClient#getLoansIncome} params. */
@Param(weight = 6000, type = RateLimitType.UID)
public class LoanIncomeHistoryParams implements Params {
	/** The asset */
	@Mandatory
	String asset;
	/** The loan income type. All types will be returned by default. */
	LoanIncomeType type;
	/** The starting timestamp of the results */
	Long startTime;
	/** The ending timestamp of the results */
	Long endTime;
	/** The result limit. Default 20, max 100. */
	Integer limit;

	/**
	 * @param asset The asset we want the incomes.
	 */
	public LoanIncomeHistoryParams(String asset) {
		this.asset = asset;
	}

	/**
	 * @return the asset
	 */
	public String getAsset() {
		return asset;
	}

	/**
	 * @param asset the asset to set
	 */
	public void setAsset(String asset) {
		this.asset = asset;
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

	/**
	 * @return the type
	 */
	public LoanIncomeType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(LoanIncomeType type) {
		this.type = type;
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