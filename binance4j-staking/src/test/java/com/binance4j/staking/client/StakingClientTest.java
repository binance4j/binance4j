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

	public StakingClientTest() {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetHistory() throws ApiException {
		testHistory(client.getHistory(new HistoryParams(ProductType.STAKING, TransactionType.INTEREST)));
		testHistory(client.getHistory(new HistoryParams(ProductType.STAKING, TransactionType.REDEMPTION)));
		testHistory(client.getHistory(new HistoryParams(ProductType.STAKING, TransactionType.SUBSCRIPTION)));
	}

	@Test
	void testGetLeftQuota() throws ApiException {
		testNoNulls(client.getLeftQuota(new LeftQuotaParams(ProductType.STAKING, productId)));
	}

	@Test
	void testGetPosition() throws ApiException {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testPosition(client.getPosition(new PositionParams(ProductType.STAKING)).sync());
		testPosition(client.getPosition(new PositionParams(ProductType.F_DEFI)).sync());
		testPosition(client.getPosition(new PositionParams(ProductType.L_DEFI)).sync());
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	void testGetProducts() throws ApiException {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testHasNulls(client.getProducts(new ProductListParams(ProductType.STAKING)),
				List.of("extraRewardAsset", "extraRewardsAPY"), true);
		testHasNulls(client.getProducts(new ProductListParams(ProductType.F_DEFI)),
				List.of("extraRewardAsset", "extraRewardsAPY"), true);
		testHasNulls(client.getProducts(new ProductListParams(ProductType.L_DEFI)),
				List.of("extraRewardAsset", "extraRewardsAPY"), true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
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
		testNoNulls(client.purchase(new PurchaseParams(ProductType.STAKING, "productId", "amount")));
	}

	// TODO @Test
	void testRedeem() throws ApiException {
		testNoNulls(client.redeem(new RedeemParams(ProductType.STAKING, "productId")));
	}

	// TODO @Test
	void testSetAutoStaking() throws ApiException {
		testNoNulls(client.setAutoStaking(new AutoStakingParams(ProductType.STAKING, "", true)));
	}
}
