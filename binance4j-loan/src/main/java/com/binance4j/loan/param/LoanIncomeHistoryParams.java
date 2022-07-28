package com.binance4j.loan.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.loan.client.LoanClient;
import com.binance4j.loan.dto.LoanIncomeType;

/**
 * The {@link LoanClient#getLoansIncome} params.
 * 
 * @param asset The asset we want the incomes.
 * @param type  The loan income type. All types will be returned by default.
 */
@Param(weight = 6000, type = RateLimitType.UID)
public record LoanIncomeHistoryParams(@Mandatory String asset, LoanIncomeType type) implements Params {
	/**
	 * Creates an instance of {@link LoanIncomeHistoryParams}.
	 * 
	 * @param asset The asset we want the incomes.
	 */
	public LoanIncomeHistoryParams(String asset) {
		this(asset, null);
	}
}