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
import com.binance4j.savings.request.GetAccountRequest;
import com.binance4j.savings.request.GetFixedProjectPositionRequest;
import com.binance4j.savings.request.GetFixedProjectsRequest;
import com.binance4j.savings.request.GetFlexibleProductPositionRequest;
import com.binance4j.savings.request.GetFlexibleProductsRequest;
import com.binance4j.savings.request.GetInterestsRequest;
import com.binance4j.savings.request.GetLeftDailyFlexiblePurchaseQuotaRequest;
import com.binance4j.savings.request.GetLeftDailyRedemptionQuotaRequest;
import com.binance4j.savings.request.GetPurchasesRequest;
import com.binance4j.savings.request.GetRedemptionsRequest;
import com.binance4j.savings.request.PositionChangedRequest;
import com.binance4j.savings.request.PurchaseFlexibleRequest;
import com.binance4j.savings.request.RedeemFlexibleRequest;

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
	public GetFlexibleProductsRequest getFlexibleProducts(FlexibleProductsParams params) {
		return new GetFlexibleProductsRequest(service.getFlexibleProducts(params.toMap()));
	}

	/**
	 * Get flexible product list.
	 *
	 * @param params Request params.
	 * @param paging Pagign.
	 * @return The request to execute.
	 */
	public GetFlexibleProductsRequest getFlexibleProducts(FlexibleProductsParams params, Paging paging) {
		var replaceMap = Map.of("page", "current", "limit", "size");
		return new GetFlexibleProductsRequest(
				service.getFlexibleProducts(Params.merge(params.toMap(), paging.toMap(replaceMap))));
	}

	/**
	 * Get flexible product list.
	 *
	 * @return The request to execute.
	 */
	public GetFlexibleProductsRequest getFlexibleProducts() {
		return new GetFlexibleProductsRequest(service.getFlexibleProducts(new FlexibleProductsParams().toMap()));
	}

	/**
	 * Get left daily purchase quota of flexible product.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetLeftDailyFlexiblePurchaseQuotaRequest getLeftDailyFlexiblePurchaseQuota(PurchaseQuotaParams params) {
		return new GetLeftDailyFlexiblePurchaseQuotaRequest(service.getLeftDailyFlexiblePurchaseQuota(params.toMap()));
	}

	/**
	 * Purchase Flexible Product.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public PurchaseFlexibleRequest purchaseFlexible(FlexiblePurchaseParams params) {
		return new PurchaseFlexibleRequest(service.purchaseFlexible(params.toMap()));
	}

	/**
	 * Get Left Daily Redemption Quota of Flexible Product.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetLeftDailyRedemptionQuotaRequest getLeftDailyRedemptionQuota(RedemptionQuotaParams params) {
		return new GetLeftDailyRedemptionQuotaRequest(service.getLeftDailyRedemptionQuota(params.toMap()));
	}

	/**
	 * Redeem Flexible Product.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public RedeemFlexibleRequest redeemFlexible(RedemptionParams params) {
		return new RedeemFlexibleRequest(service.redeemFlexible(params.toMap()));
	}

	/**
	 * Get flexible product position.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetFlexibleProductPositionRequest getFlexibleProductPosition(FlexibleProductPositionParams params) {
		return new GetFlexibleProductPositionRequest(service.getFlexibleProductPosition(params.toMap()));
	}

	/**
	 * Get flexible product position.
	 *
	 * @return The request to execute.
	 */
	public GetFlexibleProductPositionRequest getFlexibleProductPosition() {
		return new GetFlexibleProductPositionRequest(
				service.getFlexibleProductPosition(new FlexibleProductPositionParams(null).toMap()));
	}

	/**
	 * Get fixed and activity project list.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<FixedProject>> getFixedProjects(FixedProjectListParams params) {
		return new GetFixedProjectsRequest(service.getFixedProjects(params.toMap()));
	}

	/**
	 * Get fixed and activity project list.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public GetFixedProjectsRequest getFixedProjects(FixedProjectListParams params, Paging paging) {
		return new GetFixedProjectsRequest(service.getFixedProjects(
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
	public GetFixedProjectsRequest getFixedProjects(FixedProjectListParams params, Paging paging, Sorting sorting) {
		return new GetFixedProjectsRequest(service.getFixedProjects(Params.merge(params.toMap(), sorting.toMap(),
				paging.toMap(Map.of("page", "current", "limit", "size")))));
	}

	/**
	 * Get fixed and activity project list.
	 * 
	 * @param params  Request params.
	 * @param sorting Sorting.
	 * @return The request to execute.
	 */
	public GetFixedProjectsRequest getFixedProjects(FixedProjectListParams params, Sorting sorting) {
		return new GetFixedProjectsRequest(service.getFixedProjects(Params.merge(params.toMap(), sorting.toMap())));
	}

	/**
	 * Purchase fixed project.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public PurchaseFlexibleRequest purchaseFixed(FixedPurchaseParams params) {
		return new PurchaseFlexibleRequest(service.purchaseFixed(params.toMap()));
	}

	/**
	 * Get fixed/activity project position.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetFixedProjectPositionRequest getFixedProjectPosition(FixedProjectPositionParams params) {
		return new GetFixedProjectPositionRequest(service.getFixedProjectPosition(params.toMap()));
	}

	/**
	 * Get lending account.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetAccountRequest getAccount(LendingAccountParams params) {
		return new GetAccountRequest(service.getAccount(params.toMap()));
	}

	/**
	 * Get lending account.
	 *
	 * @return The request to execute.
	 */
	public GetAccountRequest getAccount() {
		return new GetAccountRequest(service.getAccount(new LendingAccountParams().toMap()));
	}

	/**
	 * Get purchase record.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetPurchasesRequest getPurchases(LendingParams params) {
		return new GetPurchasesRequest(service.getPurchases(params.toMap()));
	}

	/**
	 * Get purchase record.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public GetPurchasesRequest getPurchases(LendingParams params, FramedPaging paging) {
		var paginationReplace = Map.of("page", "current", "limit", "size");
		return new GetPurchasesRequest(
				service.getPurchases(Params.merge(params.toMap(), paging.toMap(paginationReplace))));
	}

	/**
	 * Get redemption record.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetRedemptionsRequest getRedemptions(LendingParams params) {
		return new GetRedemptionsRequest(service.getRedemptions(params.toMap()));
	}

	/**
	 * Get redemption record.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public GetRedemptionsRequest getRedemptions(LendingParams params, FramedPaging paging) {
		var paginationReplace = Map.of("page", "current", "limit", "size");
		return new GetRedemptionsRequest(
				service.getRedemptions(Params.merge(params.toMap(), paging.toMap(paginationReplace))));
	}

	/**
	 * Get interest record.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetInterestsRequest getInterests(LendingParams params) {
		return new GetInterestsRequest(service.getInterests(params.toMap()));
	}

	/**
	 * Get interest record.
	 * 
	 * @param params    Request params.
	 * @param timeFrame Time frame.
	 * @return The request to execute.
	 */
	public GetInterestsRequest getInterests(LendingParams params, TimeFrame timeFrame) {
		return new GetInterestsRequest(service.getInterests(Params.merge(params, timeFrame)));
	}

	/**
	 * Get interest record.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public GetInterestsRequest getInterests(LendingParams params, FramedPaging paging) {
		var paginationReplace = Map.of("page", "current", "limit", "size");
		return new GetInterestsRequest(
				service.getInterests(Params.merge(params.toMap(), paging.toMap(paginationReplace))));
	}

	/**
	 * Change fixed/activity position to daily position.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public PositionChangedRequest fixedToDailyPosition(ChangePositionParams params) {
		return new PositionChangedRequest(service.fixedToDailyPosition(params.toMap()));
	}
}