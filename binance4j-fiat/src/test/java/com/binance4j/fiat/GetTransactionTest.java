package com.binance4j.fiat;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.fiat.dto.TransactionType;
import com.binance4j.fiat.param.TransactionParams;

public class GetTransactionTest extends FiatTest {

	@Test
	void testGetDeposits() throws ApiException {
		var params = new TransactionParams(TransactionType.DEPOSIT);
		params.setBeginTime(System.currentTimeMillis() - Duration.ofDays(365).toMillis());
		test(client.getTransactions(params));
	}

	@Test
	void testGetWithdraws() throws ApiException {
		var params = new TransactionParams(TransactionType.WITHDRAW);
		params.setBeginTime(System.currentTimeMillis() - Duration.ofDays(365).toMillis());
		test(client.getTransactions(params));
	}
}
