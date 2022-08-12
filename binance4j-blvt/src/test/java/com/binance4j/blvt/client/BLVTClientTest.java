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
	BLVTClient client = new BLVTClient(key, secret);

	@Override
	protected BLVTClient getClient() {
		return client;
	}

	TimeFrame timeFrame = new TimeFrame(limit);
	String tokenName = "1INCHDOWN";
	String amount = "1";

	@Test
	void testGetLimitInfo() throws ApiException {
		testNotThrow(getClient().getLimitInfo());
	}

	@Test
	void testGetLimitInfo2() throws ApiException {
		testNotThrow(getClient().getLimitInfo(new LimitInfoParams(tokenName)));
	}

	@Test
	void testGetRedemptions() throws ApiException {
		testNotThrow(getClient().getRedemptions());
	}

	@Test
	void testGetRedemptionsWithTimeFrame() throws ApiException {
		testNotThrow(getClient().getRedemptions(new TransactionRecordParams(tokenName, 0L), timeFrame));
	}

	@Test
	void testGetSubscriptions() throws ApiException {
		testNotThrow(getClient().getSubscriptions());
	}

	@Test
	void testGetSubscriptionsWithTimeFrame() throws ApiException {
		testNotThrow(getClient().getSubscriptions(new TransactionRecordParams(tokenName), timeFrame));
	}

	@Test
	void testGetTokenInfo() throws ApiException {
		testNotThrow(getClient().getTokenInfo());
	}

	@Test
	void testGetTokenInfoWithParams() throws ApiException {
		testNotThrow(getClient().getTokenInfo(new TokenInfoParams(tokenName)));
	}

	// NOT TEST DUE TO NEW FRENCH LAWS

	// TODO @Test
	void testRedeem() throws ApiException {
		testNotThrow(getClient().redeem(new RedemptionParams(tokenName, amount)));
	}

	// TODO @Test
	void testSubscribe() throws ApiException {
		testNotThrow(getClient().subscribe(new SubscriptionParams(tokenName, amount)));
	}

	// TODO @Test
	void testGetRedemptionsWithParams() throws ApiException {
		testNotThrow(getClient().getRedemptions(new TransactionRecordParams(tokenName, 0L)));
	}
}
