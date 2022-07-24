package com.binance4j.loan.dto;

/** Loan income type. */
public enum LoanIncomeType {
	/** Borrow in */
	borrowIn,
	/** Collateral spent */
	collateralSpent,
	/** Repay amount */
	repayAmount,
	/** Collateral return after repayment. */
	collateralReturn,
	/** Add collatera l */
	addCollateral,
	/** Remove collateral */
	removeCollateral,
	/** collateral return after liquidation */
	collateralReturnAfterLiquidation
}
