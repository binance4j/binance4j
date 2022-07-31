package com.binance4j.fiat;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.fiat.dto.TransactionType;
import com.binance4j.fiat.param.TransactionParams;

public class GetTransactionTest extends FiatTest {
	@Test
	void testGetDeposits() throws ApiException {
		var params = new TransactionParams(TransactionType.DEPOSIT, oneYearAgo, null);
		testNoNulls(client.getTransactions(params));
	}

	@Test
	void testGetWithdraws() throws ApiException {
		var params = new TransactionParams(TransactionType.WITHDRAW, oneYearAgo, null);
		testNoNulls(client.getTransactions(params));
	}
}
