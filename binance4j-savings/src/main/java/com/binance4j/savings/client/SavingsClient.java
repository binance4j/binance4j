package com.binance4j.savings.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Paging;
import com.binance4j.core.param.Params;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.savings.dto.FixedProject;
import com.binance4j.savings.dto.FixedProjectPosition;
import com.binance4j.savings.dto.FlexibleProduct;
import com.binance4j.savings.dto.FlexibleProductPosition;
import com.binance4j.savings.dto.Interest;
import com.binance4j.savings.dto.LendingAccount;
import com.binance4j.savings.dto.PositionChangedResponse;
import com.binance4j.savings.dto.Purchase;
import com.binance4j.savings.dto.PurchaseQuota;
import com.binance4j.savings.dto.PurchaseResponse;
import com.binance4j.savings.dto.Redemption;
import com.binance4j.savings.dto.RedemptionQuota;
import com.binance4j.savings.dto.Sorting;
import com.binance4j.savings.param.ChangePositionParams;
import com.binance4j.savings.param.FixedProjectListParams;
import com.binance4j.savings.param.FixedProjectPositionParams;
import com.binance4j.savings.param.FixedPurchaseParams;
import com.binance4j.savings.param.FlexibleProductPositionParams;
import com.binance4j.savings.param.FlexibleProductsParams;
import com.binance4j.savings.param.FlexiblePurchaseParams;
import com.binance4j.savings.param.LendingAccountParams;
import com.binance4j.savings.param.LendingParams;
import com.binance4j.savings.param.PurchaseQuotaParams;
import com.binance4j.savings.param.RedemptionParams;
import com.binance4j.savings.param.RedemptionQuotaParams;

/**
 * Api client for the savings endpoints
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#savings-endpoints">Documentation</a>
 */
public class SavingsClient extends RestClient<SavingsMapping> {
	/**
	 * @param key    API public key.
	 * @param secret API secret key.
	 */
	public SavingsClient(String key, String secret) {
		super(SavingsMapping.class, key, secret);
	}

	/**
	 * Get flexible product list.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<FlexibleProduct>> getFlexibleProducts(FlexibleProductsParams params) {
		return new Request<>(service.getFlexibleProducts(params.toMap()));
	}

	/**
	 * Get flexible product list.
	 *
	 * @param params Request params.
	 * @param paging Pagign.
	 * @return The request to execute.
	 */
	public Request<List<FlexibleProduct>> getFlexibleProducts(FlexibleProductsParams params, Paging paging) {
		var replaceMap = Map.of("page", "current", "limit", "size");
		return new Request<>(service.getFlexibleProducts(Params.merge(params.toMap(), paging.toMap(replaceMap))));
	}

	/**
	 * Get flexible product list.
	 *
	 * @return The request to execute.
	 */
	public Request<List<FlexibleProduct>> getFlexibleProducts() {
		return new Request<>(service.getFlexibleProducts(new FlexibleProductsParams().toMap()));
	}

	/**
	 * Get left daily purchase quota of flexible product.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<PurchaseQuota> getLeftDailyFlexiblePurchaseQuota(PurchaseQuotaParams params) {
		return new Request<>(service.getLeftDailyFlexiblePurchaseQuota(params.toMap()));
	}

	/**
	 * Purchase Flexible Product.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<PurchaseResponse> purchaseFlexible(FlexiblePurchaseParams params) {
		return new Request<>(service.purchaseFlexible(params.toMap()));
	}

	/**
	 * Get Left Daily Redemption Quota of Flexible Product.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<RedemptionQuota> getLeftDailyRedemptionQuota(RedemptionQuotaParams params) {
		return new Request<>(service.getLeftDailyRedemptionQuota(params.toMap()));
	}

	/**
	 * Redeem Flexible Product.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<Void> redeemFlexible(RedemptionParams params) {
		return new Request<>(service.redeemFlexible(params.toMap()));
	}

	/**
	 * Get flexible product position.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<FlexibleProductPosition>> getFlexibleProductPosition(FlexibleProductPositionParams params) {
		return new Request<>(service.getFlexibleProductPosition(params.toMap()));
	}

	/**
	 * Get flexible product position.
	 *
	 * @return The request to execute.
	 */
	public Request<List<FlexibleProductPosition>> getFlexibleProductPosition() {
		return new Request<>(service.getFlexibleProductPosition(new FlexibleProductPositionParams(null).toMap()));
	}

	/**
	 * Get fixed and activity project list.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<FixedProject>> getFixedProjects(FixedProjectListParams params) {
		return new Request<>(service.getFixedProjects(params.toMap()));
	}

	/**
	 * Get fixed and activity project list.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public Request<List<FixedProject>> getFixedProjects(FixedProjectListParams params, Paging paging) {
		return new Request<>(service.getFixedProjects(
				Params.merge(params.toMap(), paging.toMap(Map.of("page", "current", "limit", "size")))));
	}

	/**
	 * Get fixed and activity project list.
	 * 
	 * @param params  Request params.
	 * @param paging  Paging.
	 * @param sorting Sorting.
	 * @return The request to execute.
	 */
	public Request<List<FixedProject>> getFixedProjects(FixedProjectListParams params, Paging paging, Sorting sorting) {
		return new Request<>(service.getFixedProjects(Params.merge(params.toMap(), sorting.toMap(),
				paging.toMap(Map.of("page", "current", "limit", "size")))));
	}

	/**
	 * Get fixed and activity project list.
	 * 
	 * @param params  Request params.
	 * @param sorting Sorting.
	 * @return The request to execute.
	 */
	public Request<List<FixedProject>> getFixedProjects(FixedProjectListParams params, Sorting sorting) {
		return new Request<>(service.getFixedProjects(Params.merge(params.toMap(), sorting.toMap())));
	}

	/**
	 * Purchase fixed project.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<PurchaseResponse> purchaseFixed(FixedPurchaseParams params) {
		return new Request<>(service.purchaseFixed(params.toMap()));
	}

	/**
	 * Get fixed/activity project position.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<FixedProjectPosition>> getFixedProjectPosition(FixedProjectPositionParams params) {
		return new Request<>(service.getFixedProjectPosition(params.toMap()));
	}

	/**
	 * Get lending account.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<LendingAccount> getAccount(LendingAccountParams params) {
		return new Request<>(service.getAccount(params.toMap()));
	}

	/**
	 * Get lending account.
	 *
	 * @return The request to execute.
	 */
	public Request<LendingAccount> getAccount() {
		return new Request<>(service.getAccount(new LendingAccountParams().toMap()));
	}

	/**
	 * Get purchase record.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<Purchase>> getPurchases(LendingParams params) {
		return new Request<>(service.getPurchases(params.toMap()));
	}

	/**
	 * Get purchase record.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public Request<List<Purchase>> getPurchases(LendingParams params, FramedPaging paging) {
		var paginationReplace = Map.of("page", "current", "limit", "size");
		return new Request<>(service.getPurchases(Params.merge(params.toMap(), paging.toMap(paginationReplace))));
	}

	/**
	 * Get redemption record.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<Redemption>> getRedemptions(LendingParams params) {
		return new Request<>(service.getRedemptions(params.toMap()));
	}

	/**
	 * Get redemption record.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public Request<List<Redemption>> getRedemptions(LendingParams params, FramedPaging paging) {
		var paginationReplace = Map.of("page", "current", "limit", "size");
		return new Request<>(service.getRedemptions(Params.merge(params.toMap(), paging.toMap(paginationReplace))));
	}

	/**
	 * Get interest record.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<Interest>> getInterests(LendingParams params) {
		return new Request<>(service.getInterests(params.toMap()));
	}

	/**
	 * Get interest record.
	 * 
	 * @param params    Request params.
	 * @param timeFrame Time frame.
	 * @return The request to execute.
	 */
	public Request<List<Interest>> getInterests(LendingParams params, TimeFrame timeFrame) {
		return new Request<>(service.getInterests(Params.merge(params, timeFrame)));
	}

	/**
	 * Get interest record.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public Request<List<Interest>> getInterests(LendingParams params, FramedPaging paging) {
		var paginationReplace = Map.of("page", "current", "limit", "size");
		return new Request<>(service.getInterests(Params.merge(params.toMap(), paging.toMap(paginationReplace))));
	}

	/**
	 * Change fixed/activity position to daily position.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<PositionChangedResponse> fixedToDailyPosition(ChangePositionParams params) {
		return new Request<>(service.fixedToDailyPosition(params.toMap()));
	}
}