package com.binance4j.fiat;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.fiat.dto.PaymentType;
import com.binance4j.fiat.param.PaymentParams;

public class GetPaymentTest extends FiatTest {
	@Test
	void testGetPurchases() throws ApiException {
		var params = new PaymentParams(PaymentType.BUY, oneYearAgo, null);
		testNoNulls(client.getPayments(params));
	}

	@Test
	void testGetSales() throws ApiException {
		var params = new PaymentParams(PaymentType.SELL, oneYearAgo, null);
		testNoNulls(client.getPayments(params));
	}
}
