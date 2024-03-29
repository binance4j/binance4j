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
import com.fasterxml.jackson.databind.DeserializationFeature;

public class FiatClientTest extends CustomTest {
	protected FiatClient client = new FiatClient(key, secret);

	public FiatClientTest() {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetPayments() throws ApiException, InterruptedException {
		testNotThrow(client.getPayments(new PaymentParams(PaymentType.SELL)));
	}

	@Test
	void testGetPayments2() throws ApiException, InterruptedException {
		TimeUnit.SECONDS.sleep(10);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testNotThrow(client.getPayments(new PaymentParams(PaymentType.BUY), new FramedPaging(1)));
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetTransactions() throws ApiException, InterruptedException {
		TimeUnit.SECONDS.sleep(20);
		testNotThrow(client.getTransactions(new TransactionParams(TransactionType.WITHDRAW)));
	}

	@Test
	void testGetTransactions2() throws ApiException, InterruptedException {
		TimeUnit.SECONDS.sleep(30);
		testNotThrow(client.getTransactions(new TransactionParams(TransactionType.DEPOSIT), new FramedPaging(1)));
	}
}
