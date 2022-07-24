package com.binance4j.loan;

import com.binance4j.core.test.CustomTest;
import com.binance4j.loan.client.LoanClient;

public abstract class LoanTest extends CustomTest<LoanClient> {
	public LoanTest() {
		super(LoanClient.class);
	}
}
