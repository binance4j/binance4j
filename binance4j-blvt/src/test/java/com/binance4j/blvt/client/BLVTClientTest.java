package com.binance4j.blvt.client;

import org.junit.jupiter.api.Test;

import com.binance4j.blvt.param.LimitInfoParams;
import com.binance4j.blvt.param.RedemptionParams;
import com.binance4j.blvt.param.SubscriptionParams;
import com.binance4j.blvt.param.TokenInfoParams;
import com.binance4j.blvt.param.TransactionRecordParams;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.core.test.CustomTest;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class BLVTClientTest extends CustomTest {
	BLVTClient client = new BLVTClient(key, secret);

	public BLVTClientTest() {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	TimeFrame timeFrame = new TimeFrame(limit);
	String tokenName = "1INCHDOWN";
	String amount = "1";

	@Test
	void testGetLimitInfo() throws ApiException {
		testNotThrow(client.getLimitInfo());
	}

	@Test
	void testGetLimitInfo2() throws ApiException {
		testNotThrow(client.getLimitInfo(new LimitInfoParams(tokenName)));
	}

	@Test
	void testGetRedemptions() throws ApiException {
		testNotThrow(client.getRedemptions());
	}

	@Test
	void testGetRedemptionsWithTimeFrame() throws ApiException {
		testNotThrow(client.getRedemptions(new TransactionRecordParams(tokenName, 0L), timeFrame));
	}

	@Test
	void testGetSubscriptions() throws ApiException {
		testNotThrow(client.getSubscriptions());
	}

	@Test
	void testGetSubscriptionsWithTimeFrame() throws ApiException {
		testNotThrow(client.getSubscriptions(new TransactionRecordParams(tokenName), timeFrame));
	}

	@Test
	void testGetTokenInfo() throws ApiException {
		testNotThrow(client.getTokenInfo());
	}

	@Test
	void testGetTokenInfoWithParams() throws ApiException {
		testNotThrow(client.getTokenInfo(new TokenInfoParams(tokenName)));
	}

	// NOT TEST DUE TO NEW FRENCH LAWS

	// TODO @Test
	void testRedeem() throws ApiException {
		testNotThrow(client.redeem(new RedemptionParams(tokenName, amount)));
	}

	// TODO @Test
	void testSubscribe() throws ApiException {
		testNotThrow(client.subscribe(new SubscriptionParams(tokenName, amount)));
	}

	// TODO @Test
	void testGetRedemptionsWithParams() throws ApiException {
		testNotThrow(client.getRedemptions(new TransactionRecordParams(tokenName, 0L)));
	}
}
