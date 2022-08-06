package com.binance4j.loan.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.loan.client.LoanClient;
import com.binance4j.loan.dto.LoanIncomeType;

/**
 * {@link LoanClient#getLoansIncome} params.
 * 
 * @param asset Asset we want the incomes.
 * @param type  Loan income type. All types will be returned by default.
 */
@Param(weight = 6000, type = RateLimitType.UID)
public record LoanIncomeHistoryParams(String asset, LoanIncomeType type) implements Params {
	/**
	 * Creates an instance of the class.
	 * 
	 * @param asset Asset we want the incomes.
	 * @param type  Loan income type. All types will be returned by default.
	 */
	public LoanIncomeHistoryParams(String asset, LoanIncomeType type) {
		this.asset = asset;
		this.type = type;
	}

	/**
	 * Creates an instance of the class.
	 * 
	 * @param asset Asset we want the incomes.
	 */
	public LoanIncomeHistoryParams(String asset) {
		this(asset, null);
	}
}