package com.binance4j.staking.client;

import java.util.Map;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Paging;
import com.binance4j.core.param.Params;
import com.binance4j.staking.param.AutoStakingParams;
import com.binance4j.staking.param.HistoryParams;
import com.binance4j.staking.param.LeftQuotaParams;
import com.binance4j.staking.param.PositionParams;
import com.binance4j.staking.param.ProductListParams;
import com.binance4j.staking.param.PurchaseParams;
import com.binance4j.staking.param.RedeemParams;
import com.binance4j.staking.request.GetHistoryRequest;
import com.binance4j.staking.request.GetLeftQuotaRequest;
import com.binance4j.staking.request.GetPositionRequest;
import com.binance4j.staking.request.GetProductsRequest;
import com.binance4j.staking.request.PurchaseRequest;
import com.binance4j.staking.request.RedeemRequest;
import com.binance4j.staking.request.SetAutoStakingRequest;

/**
 * Api client for the staking endpoints
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#staking-endpoints">Documentation</a>
 */
public class StakingClient extends RestClient<StakingMapping> {
	/**
	 * @param key    API public key.
	 * @param secret API secret key.
	 */
	public StakingClient(String key, String secret) {
		super(StakingMapping.class, key, secret);
	}

	/**
	 * Get available Staking product list.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetProductsRequest getProducts(ProductListParams params) {
		return new GetProductsRequest(service.getProductList(params.toMap()));
	}

	/**
	 * Get available Staking product list.
	 * 
	 * @param params     Request params.
	 * @param pagination Search pagination.
	 * @return The request to execute.
	 */
	public GetProductsRequest getProducts(ProductListParams params, Paging pagination) {
		var replaceMap = Map.of("page", "current", "limit", "size");
		return new GetProductsRequest(
				service.getProductList(Params.merge(params.toMap(), pagination.toMap(replaceMap))));
	}

	/**
	 * Purchase Staking product.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public PurchaseRequest purchase(PurchaseParams params) {
		return new PurchaseRequest(service.purchase(params.toMap()));
	}

	/**
	 * Redeem Staking product.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public RedeemRequest redeem(RedeemParams params) {
		return new RedeemRequest(service.redeem(params.toMap()));
	}

	/**
	 * Get Staking product position.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetPositionRequest getPosition(PositionParams params) {
		return new GetPositionRequest(service.getPosition(params.toMap()));
	}

	/**
	 * Get Staking product position.
	 * 
	 * @param params Request params.
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	public GetPositionRequest getPosition(PositionParams params, Paging paging) {
		var replaceMap = Map.of("page", "current", "limit", "size");
		return new GetPositionRequest(service.getPosition(Params.merge(params.toMap(), paging.toMap(replaceMap))));
	}

	/**
	 * Get staking history.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetHistoryRequest getHistory(HistoryParams params) {
		return new GetHistoryRequest(service.getHistory(params.toMap()));
	}

	/**
	 * Get staking history.
	 * 
	 * @param params   Request params.
	 * @param interval Search interval.
	 * @return The request to execute.
	 */
	public GetHistoryRequest getHistory(HistoryParams params, FramedPaging interval) {
		var replaceMap = Map.of("page", "current", "limit", "size");
		return new GetHistoryRequest(service.getHistory(Params.merge(params.toMap(), interval.toMap(replaceMap))));
	}

	/**
	 * Set auto staking on Locked Staking or Locked DeFi Staking.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public SetAutoStakingRequest setAutoStaking(AutoStakingParams params) {
		return new SetAutoStakingRequest(service.setAutoStaking(params.toMap()));
	}

	/**
	 * Get personal left quota of Staking product.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetLeftQuotaRequest getLeftQuota(LeftQuotaParams params) {
		return new GetLeftQuotaRequest(service.getLeftQuota(params.toMap()));
	}
}
