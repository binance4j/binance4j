package com.binance4j.loan;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.loan.param.LoanIncomeHistoryParams;

public class GetLoansIncomeTest extends LoanTest {
	@Test
	void test1() throws ApiException {
		test(client.getLoansIncome(new LoanIncomeHistoryParams(asset)));
	}
}
