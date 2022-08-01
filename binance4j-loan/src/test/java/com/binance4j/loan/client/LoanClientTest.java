package com.binance4j.loan.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.core.test.CustomTest;
import com.binance4j.loan.param.LoanIncomeHistoryParams;

public class LoanClientTest extends CustomTest {
	protected LoanClient client = new LoanClient(key, secret);

	@Test
	void testGetLoansIncome() throws ApiException {
		testNoNulls(client.getLoansIncome(new LoanIncomeHistoryParams(asset)));
	}

	@Test
	void testGetLoansIncome2() throws ApiException {
		testNoNulls(client.getLoansIncome(new LoanIncomeHistoryParams(asset), new TimeFrame(25)));
	}
}
