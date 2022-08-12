package com.binance4j.loan.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.core.test.CustomTest;
import com.binance4j.loan.param.LoanIncomeHistoryParams;

public class LoanClientTest extends CustomTest {
	protected LoanClient client = new LoanClient(key, secret);

	@Override
	protected LoanClient getClient() {
		return client;
	}

	@Test
	void testGetLoansIncome() throws ApiException {
		testNotThrow(getClient().getLoansIncome(new LoanIncomeHistoryParams(asset)));
	}

	@Test
	void testGetLoansIncome2() throws ApiException {
		testNotThrow(getClient().getLoansIncome(new LoanIncomeHistoryParams(asset), new TimeFrame(25)));
	}
}
