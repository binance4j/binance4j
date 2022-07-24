package com.binance4j.loan.param;

import com.binance4j.core.dto.WeightType;
import com.binance4j.core.param.IntervalParams;
import com.binance4j.loan.client.LoanClient;
import com.binance4j.loan.dto.LoanIncomeType;

/** The {@link LoanClient#getIncomes} params. */
public class LoanIncomeHistoryParams extends IntervalParams {
	/** The asset */
	private String asset;
	/** The result limit. Default 20, max 100. */
	private Integer limit;
	/** The loan income type. All types will be returned by default. */
	private LoanIncomeType type;

	/**
	 * @param asset The asset we want the incomes.
	 */
	public LoanIncomeHistoryParams(String asset) {
		super(6000);
		this.weightType = WeightType.UID;
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
}