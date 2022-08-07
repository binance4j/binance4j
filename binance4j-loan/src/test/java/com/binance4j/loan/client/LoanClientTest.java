package com.binance4j.loan.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.core.test.CustomTest;
import com.binance4j.loan.param.LoanIncomeHistoryParams;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class LoanClientTest extends CustomTest {
	protected LoanClient client = new LoanClient(key, secret);

	public LoanClientTest() {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetLoansIncome() throws ApiException {
		testNotThrow(client.getLoansIncome(new LoanIncomeHistoryParams(asset)));
	}

	@Test
	void testGetLoansIncome2() throws ApiException {
		testNotThrow(client.getLoansIncome(new LoanIncomeHistoryParams(asset), new TimeFrame(25)));
	}
}
