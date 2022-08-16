package com.binance4j.savings.client;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;
import com.binance4j.savings.dto.FixedProjectType;
import com.binance4j.savings.dto.LendingType;
import com.binance4j.savings.dto.ProductType;
import com.binance4j.savings.param.ChangePositionParams;
import com.binance4j.savings.param.FixedProjectListParams;
import com.binance4j.savings.param.FixedProjectPositionParams;
import com.binance4j.savings.param.FixedPurchaseParams;
import com.binance4j.savings.param.FlexiblePurchaseParams;
import com.binance4j.savings.param.LendingParams;
import com.binance4j.savings.param.PurchaseQuotaParams;
import com.binance4j.savings.param.RedemptionParams;
import com.binance4j.savings.param.RedemptionQuotaParams;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class SavingsClientTest extends CustomTest {
	SavingsClient client = new SavingsClient(key, secret);

	public SavingsClientTest() {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetAccount() throws ApiException {
		testNotThrow(client.getAccount());
	}

	@Test
	void testGetFixedProjects() throws ApiException {
		testNotThrow(client.getFixedProjects(new FixedProjectListParams(FixedProjectType.CUSTOMIZED_FIXED)));
		testNotThrow(client.getFixedProjects(new FixedProjectListParams(FixedProjectType.ACTIVITY)));
	}

	@Test
	void testGetFlexibleProducts() throws ApiException {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testHasNulls(client.getFlexibleProducts(), List.of("tierAnnualInterestRate"), true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetInterests() throws ApiException {
		testNotThrow(client.getInterests(new LendingParams(LendingType.DAILY)));
		testNotThrow(client.getInterests(new LendingParams(LendingType.ACTIVITY)));
		testNotThrow(client.getInterests(new LendingParams(LendingType.CUSTOMIZED_FIXED)));
	}

	@Test
	void testGetPurchases() throws ApiException {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testNotThrow(client.getPurchases(new LendingParams(LendingType.DAILY)));
		testNotThrow(client.getPurchases(new LendingParams(LendingType.ACTIVITY)));
		testNotThrow(client.getPurchases(new LendingParams(LendingType.CUSTOMIZED_FIXED)));
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetRedemptions() throws ApiException {
		testNotThrow(client.getRedemptions(new LendingParams(LendingType.DAILY)));
		testNotThrow(client.getRedemptions(new LendingParams(LendingType.ACTIVITY)));
		testNotThrow(client.getRedemptions(new LendingParams(LendingType.CUSTOMIZED_FIXED)));
	}

	@Test
	void testGetLeftDailyFlexiblePurchaseQuota() throws ApiException {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		var productId = client.getFlexibleProducts().sync().get(0).productId();
		testNotThrow(client.getLeftDailyFlexiblePurchaseQuota(new PurchaseQuotaParams(productId)));
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetLeftDailyRedemptionQuota() throws ApiException {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		var productId = client.getFlexibleProducts().sync().get(0).productId();
		testNotThrow(client.getLeftDailyRedemptionQuota(new RedemptionQuotaParams(productId, ProductType.FAST)));
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	// NOT TESTED

	// TODO @Test
	void testFixedToDailyPosition() throws ApiException {
		testNotThrow(client.fixedToDailyPosition(new ChangePositionParams("projectId", 0L)));
	}

	// TODO @Test
	void testGetFixedProjectPosition() throws ApiException {
		testNotThrow(client.getFixedProjectPosition(new FixedProjectPositionParams(null, null, null)));
	}

	// TODO @Test
	void testGetFlexibleProductPosition() throws ApiException {
		testNotThrow(client.getFlexibleProductPosition());
	}

	// TODO @Test
	void testPurchaseFixed() throws ApiException {
		testNotThrow(client.purchaseFixed(new FixedPurchaseParams("productId", 1L)));
	}

	// TODO @Test
	void testPurchaseFlexible() throws ApiException {
		testNotThrow(client.purchaseFlexible(new FlexiblePurchaseParams("productId", "amount")));
	}

	// TODO @Test
	void testRedeemFlexible() throws ApiException {
		testNotThrow(client.redeemFlexible(new RedemptionParams("productId", "amount", ProductType.FAST)));
	}
}