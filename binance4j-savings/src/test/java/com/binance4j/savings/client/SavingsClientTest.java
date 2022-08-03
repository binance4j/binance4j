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
	}

	@Test
	void testGetAccount() throws ApiException {
		testNoNulls(client.getAccount());
	}

	@Test
	void testGetFixedProjects() throws ApiException {
		testNoNulls(client.getFixedProjects(new FixedProjectListParams(FixedProjectType.CUSTOMIZED_FIXED)));
		testNoNulls(client.getFixedProjects(new FixedProjectListParams(FixedProjectType.ACTIVITY)));
	}

	@Test
	void testGetFlexibleProducts() throws ApiException {
		testHasNulls(client.getFlexibleProducts(), List.of("tierAnnualInterestRate"), true);
	}

	@Test
	void testGetInterests() throws ApiException {
		testNoNulls(client.getInterests(new LendingParams(LendingType.DAILY)));
		testNoNulls(client.getInterests(new LendingParams(LendingType.ACTIVITY)));
		testNoNulls(client.getInterests(new LendingParams(LendingType.CUSTOMIZED_FIXED)));
	}

	@Test
	void testGetPurchases() throws ApiException {
		testNoNulls(client.getPurchases(new LendingParams(LendingType.DAILY)));
		testNoNulls(client.getPurchases(new LendingParams(LendingType.ACTIVITY)));
		testNoNulls(client.getPurchases(new LendingParams(LendingType.CUSTOMIZED_FIXED)));
	}

	@Test
	void testGetRedemptions() throws ApiException {
		testNoNulls(client.getRedemptions(new LendingParams(LendingType.DAILY)));
		testNoNulls(client.getRedemptions(new LendingParams(LendingType.ACTIVITY)));
		testNoNulls(client.getRedemptions(new LendingParams(LendingType.CUSTOMIZED_FIXED)));
	}

	@Test
	void testGetLeftDailyFlexiblePurchaseQuota() throws ApiException {
		var productId = client.getFlexibleProducts().sync().get(0).productId();
		testNoNulls(client.getLeftDailyFlexiblePurchaseQuota(new PurchaseQuotaParams(productId)));
	}

	@Test
	void testGetLeftDailyRedemptionQuota() throws ApiException {
		var productId = client.getFlexibleProducts().sync().get(0).productId();
		testNoNulls(client.getLeftDailyRedemptionQuota(new RedemptionQuotaParams(productId, ProductType.FAST)));
	}

	// NOT TESTED

	// TODO @Test
	void testFixedToDailyPosition() throws ApiException {
		testNoNulls(client.fixedToDailyPosition(new ChangePositionParams("projectId")));
	}

	// TODO @Test
	void testGetFixedProjectPosition() throws ApiException {
		testNoNulls(client.getFixedProjectPosition(new FixedProjectPositionParams()));
	}

	// TODO @Test
	void testGetFlexibleProductPosition() throws ApiException {
		testNoNulls(client.getFlexibleProductPosition());
	}

	// TODO @Test
	void testPurchaseFixed() throws ApiException {
		testNoNulls(client.purchaseFixed(new FixedPurchaseParams("productId", 1L)));
	}

	// TODO @Test
	void testPurchaseFlexible() throws ApiException {
		testNoNulls(client.purchaseFlexible(new FlexiblePurchaseParams("productId", "amount")));
	}

	// TODO @Test
	void testRedeemFlexible() throws ApiException {
		testNoNulls(client.redeemFlexible(new RedemptionParams("productId", "amount", ProductType.FAST)));
	}
}