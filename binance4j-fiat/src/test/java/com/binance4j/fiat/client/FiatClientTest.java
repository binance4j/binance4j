package com.binance4j.fiat.client;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.test.CustomTest;
import com.binance4j.fiat.dto.PaymentType;
import com.binance4j.fiat.dto.TransactionType;
import com.binance4j.fiat.param.PaymentParams;
import com.binance4j.fiat.param.TransactionParams;

public class FiatClientTest extends CustomTest {
	protected FiatClient client = new FiatClient(key, secret);

	@Test
	void testGetPayments() throws ApiException, InterruptedException {
		testNoNulls(client.getPayments(new PaymentParams(PaymentType.SELL)));
	}

	@Test
	void testGetPayments2() throws ApiException, InterruptedException {
		TimeUnit.SECONDS.sleep(10);
		testNoNulls(client.getPayments(new PaymentParams(PaymentType.BUY), new FramedPaging(1)));
	}

	@Test
	void testGetTransactions() throws ApiException, InterruptedException {
		TimeUnit.SECONDS.sleep(20);
		testNoNulls(client.getTransactions(new TransactionParams(TransactionType.WITHDRAW)));
	}

	@Test
	void testGetTransactions2() throws ApiException, InterruptedException {
		TimeUnit.SECONDS.sleep(30);
		testNoNulls(client.getTransactions(new TransactionParams(TransactionType.DEPOSIT), new FramedPaging(1)));
	}
}
