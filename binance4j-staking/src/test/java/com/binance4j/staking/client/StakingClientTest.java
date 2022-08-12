package com.binance4j.staking.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.CustomTest;
import com.binance4j.staking.dto.ProductType;
import com.binance4j.staking.dto.TransactionType;
import com.binance4j.staking.param.AutoStakingParams;
import com.binance4j.staking.param.HistoryParams;
import com.binance4j.staking.param.LeftQuotaParams;
import com.binance4j.staking.param.PositionParams;
import com.binance4j.staking.param.ProductListParams;
import com.binance4j.staking.param.PurchaseParams;
import com.binance4j.staking.param.RedeemParams;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class StakingClientTest extends CustomTest {
	protected String productId = "Cake*120";
	protected StakingClient client = new StakingClient(key, secret);

	@Override
	protected StakingClient getClient() {
		return client;
	}

	@Test
	void testGetHistory() throws ApiException {
		testHistory(getClient().getHistory(new HistoryParams(ProductType.STAKING, TransactionType.INTEREST)));
		testHistory(getClient().getHistory(new HistoryParams(ProductType.STAKING, TransactionType.REDEMPTION)));
		testHistory(getClient().getHistory(new HistoryParams(ProductType.STAKING, TransactionType.SUBSCRIPTION)));
	}

	@Test
	void testGetLeftQuota() throws ApiException {
		testNoNulls(getClient().getLeftQuota(new LeftQuotaParams(ProductType.STAKING, productId)));
	}

	@Test
	void testGetPosition() throws ApiException {
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testPosition(getClient().getPosition(new PositionParams(ProductType.STAKING)).sync());
		testPosition(getClient().getPosition(new PositionParams(ProductType.F_DEFI)).sync());
		testPosition(getClient().getPosition(new PositionParams(ProductType.L_DEFI)).sync());
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetProducts() throws ApiException {
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testHasNulls(getClient().getProducts(new ProductListParams(ProductType.STAKING)),
				List.of("extraRewardAsset", "extraRewardsAPY"), true);
		testHasNulls(getClient().getProducts(new ProductListParams(ProductType.F_DEFI)),
				List.of("extraRewardAsset", "extraRewardsAPY"), true);
		testHasNulls(getClient().getProducts(new ProductListParams(ProductType.L_DEFI)),
				List.of("extraRewardAsset", "extraRewardsAPY"), true);
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	public void testHistory(Object bean) {
		var nulls = getNullProperties(bean);
		assertTrue(nulls.contains("deliverDate") || !nulls.contains("deliverDate"));
		assertTrue(nulls.contains("lockPeriod") || !nulls.contains("lockPeriod"));
		assertTrue(nulls.contains("project") || !nulls.contains("project"));
		assertTrue(nulls.contains("type") || !nulls.contains("type"));
	}

	public void testPosition(Object bean) {
		var nulls = getNullProperties(bean);
		assertTrue(nulls.contains("partialAmtDeliverDate") || !nulls.contains("partialAmtDeliverDate"));
		assertTrue(nulls.contains("extraRewardAsset") || !nulls.contains("extraRewardAsset"));
		assertTrue(nulls.contains("nextInterestPayDate") || !nulls.contains("nextInterestPayDate"));
		assertTrue(nulls.contains("extraRewardAPY") || !nulls.contains("extraRewardAPY"));
		assertTrue(nulls.contains("estExtraRewardAmt") || !nulls.contains("estExtraRewardAmt"));
		assertTrue(nulls.contains("redeemingAmt") || !nulls.contains("redeemingAmt"));
	}

	// NOT TESTED

	// TODO @Test
	void testPurchase() throws ApiException {
		testNoNulls(getClient().purchase(new PurchaseParams(ProductType.STAKING, "productId", "amount")));
	}

	// TODO @Test
	void testRedeem() throws ApiException {
		testNoNulls(getClient().redeem(new RedeemParams(ProductType.STAKING, "productId")));
	}

	// TODO @Test
	void testSetAutoStaking() throws ApiException {
		testNoNulls(getClient().setAutoStaking(new AutoStakingParams(ProductType.STAKING, "", true)));
	}
}
