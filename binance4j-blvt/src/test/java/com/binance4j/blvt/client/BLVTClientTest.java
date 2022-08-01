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

public class BLVTClientTest extends CustomTest {
	protected BLVTClient client = new BLVTClient(key, secret);
	TimeFrame timeFrame = new TimeFrame(limit);
	String tokenName = "1INCHDOWN";
	String amount = "1";

	@Test
	void testGetLimitInfo() throws ApiException {
		testNoNulls(client.getLimitInfo());
	}

	@Test
	void testGetLimitInfo2() throws ApiException {
		testNoNulls(client.getLimitInfo(new LimitInfoParams(tokenName)));
	}

	@Test
	void testGetRedemptions() throws ApiException {
		testNoNulls(client.getRedemptions());
	}

	// TODO @Test
	void testGetRedemptionsWithParams() throws ApiException {
		testNoNulls(client.getRedemptions(new TransactionRecordParams(tokenName, 0L)));
	}

	@Test
	void testGetRedemptionsWithTimeFrame() throws ApiException {
		testNoNulls(client.getRedemptions(new TransactionRecordParams(tokenName, 0L), timeFrame));
	}

	@Test
	void testGetSubscriptions() throws ApiException {
		testNoNulls(client.getSubscriptions());
	}

	@Test
	void testGetSubscriptionsWithParams() throws ApiException {
		testNoNulls(client.getSubscriptions(new TransactionRecordParams()));
	}

	@Test
	void testGetSubscriptionsWithTimeFrame() throws ApiException {
		testNoNulls(client.getSubscriptions(new TransactionRecordParams(tokenName), timeFrame));
	}

	@Test
	void testGetTokenInfo() throws ApiException {
		testNoNulls(client.getTokenInfo());
	}

	@Test
	void testGetTokenInfoWithParams() throws ApiException {
		testNoNulls(client.getTokenInfo(new TokenInfoParams(tokenName)));
	}

	// TODO @Test
	void testRedeem() throws ApiException {
		testNoNulls(client.redeem(new RedemptionParams(tokenName, amount)));
	}

	// TODO @Test
	void testSubscribe() throws ApiException {
		testNoNulls(client.subscribe(new SubscriptionParams(tokenName, amount)));
	}
}
